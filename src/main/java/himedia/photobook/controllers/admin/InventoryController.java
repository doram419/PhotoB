package himedia.photobook.controllers.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import himedia.photobook.repositories.vo.InventoryVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;





@WebServlet("/inventory")
public class InventoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<InventoryVo> inventory = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // 초기 재고 설정
        inventory.add(new InventoryVo("ALB001", 20000L, 50));
        inventory.add(new InventoryVo("ALB002", 25000L, 30));
        inventory.add(new InventoryVo("ALB003", 30000L, 40));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("inventory", inventory);
        request.getRequestDispatcher("/admin_inventory.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            addInventory(request);
        } else if ("sell".equals(action)) {
            sellInventory(request);
        }

        response.sendRedirect(request.getContextPath() + "/inventory");
    }

    private void addInventory(HttpServletRequest request) {
        String albumId = request.getParameter("albumId");
        Long albumPrice = Long.parseLong(request.getParameter("albumPrice"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // 기존에 있는 재고인지 확인하고 추가하거나 수량을 업데이트합니다.
        boolean found = false;
        for (InventoryVo item : inventory) {
            if (item.getAlbumId().equals(albumId)) {
                item.setAlbumPrice(albumPrice);
                item.setaQuantity(item.getaQuantity() + quantity);
                found = true;
                break;
            }
        }

        if (!found) {
            // 새로운 재고 추가
            inventory.add(new InventoryVo(albumId, albumPrice, quantity));
        }
    }

    private void sellInventory(HttpServletRequest request) {
        String albumId = request.getParameter("albumId");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // 재고 판매 처리
        for (InventoryVo item : inventory) {
            if (item.getAlbumId().equals(albumId)) {
                int currentQuantity = item.getaQuantity(); // 현재 재고 수량 가져오기
                if (currentQuantity >= quantity) {
                    item.setaQuantity(currentQuantity - quantity); // 재고 차감 처리
                } else {
                    // 판매할 재고가 현재 재고보다 많을 경우 처리할 로직 추가
                    // 예를 들어, 재고 부족 에러 처리 등
                }
                break;
            }
        }
    }
}
