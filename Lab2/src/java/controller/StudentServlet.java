/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author dclon
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
    public int rBetween(int start, int end) {
        Random random = new Random();
        return start + random.nextInt(end - start) + 1;
    }

    public Date rDate() {
        GregorianCalendar gc = new GregorianCalendar();

        int year = rBetween(1980, 2012);

        gc.set(gc.YEAR, year);

        int dayOfYear = rBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return gc.getTime();
    }

    public String rString() {
        int targetStringLength = rBetween(5, 10);
        String codeAlphaLow = "abcdefghijklmnopqrstuvwxyz";
        String codeAlphaUp = codeAlphaLow.toUpperCase();
        String code = codeAlphaLow.concat(codeAlphaUp);
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            char c = code.charAt(rBetween(0, code.length() - 1));
            buffer.append(c);
        }
        return buffer.toString();
    }

    public boolean rBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

//    int ID = 0;
//    public Student fStudent() {
//        String name = rString();
//        Boolean gender = rBoolean();
//        Date DOB = rDate();
//        return new Student(ID++, name, gender, DOB);
//    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int length = Integer.parseInt(request.getParameter("length"));
        ArrayList<Student> listStudents = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            String name = rString();
            Boolean gender = rBoolean();
            Date DOB = rDate();
            listStudents.add(new Student(i + 1, name, gender, DOB));
        }
        request.setAttribute("listStudents", listStudents);
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
