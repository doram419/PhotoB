package himedia.photobook.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import himedia.photobook.repositories.dao.OrderDaoImpl;
import himedia.photobook.services.admin.AdminCommentServiceImpl;
import himedia.photobook.services.admin.AdminDeliveryServiceImpl;
import himedia.photobook.services.admin.AdminOrderService;
import himedia.photobook.services.admin.AdminRefundServiceImpl;
import himedia.photobook.repositories.vo.BoardVo;
import himedia.photobook.repositories.vo.InventoryVo;
import himedia.photobook.services.admin.AdminInventoryServiceImpl;
import himedia.photobook.services.users.UBoardServiceImpl;


@Controller
@RequestMapping({"/admin"})
public class AdminController {
	@Autowired
	private UBoardServiceImpl uBoardService;
	@Autowired
	private AdminOrderService adminOrderService;
	@Autowired
	private AdminDeliveryServiceImpl adminDeliveryServiceImpl;
	@Autowired
	private AdminRefundServiceImpl adminRefundServiceImpl;
	@Autowired
	private AdminCommentServiceImpl adminCommentServiceImpl;
	
	private AdminInventoryServiceImpl adminInventoryService;

	
	@RequestMapping({"","/home"})
	public String home(Model model) {
	    String count = adminOrderService.count();
	    String scount = adminDeliveryServiceImpl.count();
	    String rcount = adminRefundServiceImpl.count();
	    String ccount = adminCommentServiceImpl.count();
	    model.addAttribute("OrderCount", count);
	    model.addAttribute("ShipCount", scount);
	    model.addAttribute("RefCount",rcount);
	    model.addAttribute("CsCount",ccount);
	    Map<String, Object> salesData = adminOrderService.Salecount();
        model.addAttribute("salesData", salesData);
        System.out.println("판매량 조회: "+model);
        List<Map<String,Object>> topData = adminOrderService.getTopAlbum();
        model.addAttribute("topData",topData);
        System.out.println("상위 다섯개 앨범id:"+ topData);
	    return "/WEB-INF/views/admin/admin_pages.jsp";
	}
	
	@RequestMapping({"/customerService", "/cs"})
	public String customerService(@RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value = "size", defaultValue = "5") int size ,Model md) {
		List<Map<String, Object>> list = uBoardService.getBoardInfos();
		List<BoardVo> boardList = uBoardService.getPagedBoard(page,size);
		int totalItems = uBoardService.getTotalCount();
		int totalPages = (int)Math.ceil((double)totalItems/size);
		
		md.addAttribute("postList", list);
	    md.addAttribute("currentPage", page);
	    md.addAttribute("totalPages",totalPages);
		return "/WEB-INF/views/admin/admin_customer_service.jsp";
	}
	
	/**
	 * db로 줄이지 않은 이유는 data base의 약자와 겹치기 때문
	 * */
	@RequestMapping({"/dashboard", "/dash"})
	public String dashboard() {
		return "/WEB-INF/views/admin/admin_dashboard.jsp";
	}
	
	@RequestMapping("/refund")
	public String refund() {
		return "/WEB-INF/views/admin/admin_refund.jsp";
	}
	@RequestMapping("/delivery")
	public String shipment() {
		return "/WEB-INF/views/admin/admin_delivery.jsp";
	}
	@RequestMapping("/product")
	public String product() {
		return "/WEB-INF/views/admin/admin_product.jsp";
	}
	@RequestMapping("/inventory")
	public String inventory(@RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value = "size", defaultValue = "5") int size ,Model md) {
		List<InventoryVo> list = adminInventoryService.getPagedInventory(page, size);
		int totalItems =  adminInventoryService.getTotalCount();
		int totalPages =(int)Math.ceil((double) totalItems/size);
		
		md.addAttribute("invenList",list);
	    md.addAttribute("currentPage", page);
	    md.addAttribute("totalPages",totalPages);
		return "/WEB-INF/views/admin/admin_inventory.jsp";
	}
	
}
