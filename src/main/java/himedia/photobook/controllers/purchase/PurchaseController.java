package himedia.photobook.controllers.purchase;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.photobook.repositories.vo.PhotoVo;



@Controller
public class PurchaseController {

    private final PurchaseController pc;

    public PurchaseController(PurchaseController pc) {
        this.pc = pc;
    }

    @GetMapping("/purchase")
    public String showPurchasePage(Model model) {
        model.addAttribute("photobook", new PhotoVo());
        return "purchase";
    }

    @PostMapping("/purchase")
    public String processPurchase(@RequestParam String bookType, @RequestParam int quantity, Model model) {
        // 실제로는 여기에서 포토북 구매 처리 로직을 수행합니다
    	PurchaseController.purchasePhotobook(bookType, quantity);
        model.addAttribute("bookType", bookType);
        model.addAttribute("quantity", quantity);
        return "purchase_confirm";
    }

    private static void purchasePhotobook(String bookType, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@GetMapping("/purchase/confirm")
    public String showPurchaseConfirmPage(@RequestParam String bookType, @RequestParam int quantity, Model model) {
        model.addAttribute("bookType", bookType);
        model.addAttribute("quantity", quantity);
        return "purchase_confirm";
    }

    @PostMapping("/purchase/complete")
    public String completePurchase(@RequestParam String bookType, @RequestParam int quantity, Model model) {
        model.addAttribute("bookType", bookType);
        model.addAttribute("quantity", quantity);
        // 실제 구매 완료 로직을 수행하고, 데이터베이스에 구매 내역을 저장하는 코드가 여기에 위치해야 합니다.
        return "purchase_complete";
    }
}