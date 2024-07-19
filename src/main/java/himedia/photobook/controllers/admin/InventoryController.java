package himedia.photobook.controllers.admin;


import java.io.*;
import java.util.*;

import himedia.photobook.repositories.vo.InventoryVo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/inventory", "/iv", "/inven"})
public class InventoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<InventoryVo> inventory = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // 초기 재고 설정
        inventory.add(new InventoryVo("ALB001", 20000L, "50"));
        inventory.add(new InventoryVo("ALB002", 25000L, "30"));
        inventory.add(new InventoryVo("ALB003", 30000L, "40"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("inventory", inventory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/inventory.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/addInventory":
                addInventory(request, response);
                break;
            case "/sellInventory":
                sellInventory(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/inventory");
                break;
        }
    }

    private void addInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String albumId = request.getParameter("albumId");
        Long albumPrice = Long.parseLong(request.getParameter("albumPrice"));
        String aQuantity = request.getParameter("aQuantity");
        
        inventory.add(new InventoryVo(albumId, albumPrice, aQuantity));
        response.sendRedirect(request.getContextPath() + "/inventory");
    }

    private void sellInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String albumId = request.getParameter("albumId");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        InventoryVo item = inventory.stream().filter(i -> i.getAlbumId().equals(albumId)).findFirst().orElse(null);
        if (item != null && Integer.parseInt(item.getaQuantity()) >= quantity) {
            item.setaQuantity(String.valueOf(Integer.parseInt(item.getaQuantity()) - quantity));
        }
        
        response.sendRedirect(request.getContextPath() + "/inventory");
    }
}

