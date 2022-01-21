/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author 
 */
public class StudentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public Date sDate() {
        int year = 2020;// generate a year between 1900 and 2010;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2020);
        Random random = new Random();
        int dayOfYear = random.nextInt(366);// generate a number between 1 and 365 (or 366 if you need to handle leap year);
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
        Date randomDoB = calendar.getTime();
        return randomDoB;
    }

    public String sString() {
        Random random = new Random();
        int targetStringLength = 5 + random.nextInt(5) + 1;
        int leftLimit = (int) 'a';
        int rightLimit = (int) 'z';
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public boolean sBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int length = Integer.parseInt(request.getParameter("length"));
        ArrayList<Student> listStudents = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            String name = sString();
            Boolean gender = sBoolean();
            Date DOB = sDate();
            listStudents.add(new Student(i + 1, name, gender, DOB));
        }
        request.setAttribute("data", listStudents);
        request.setAttribute("length", length);
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
