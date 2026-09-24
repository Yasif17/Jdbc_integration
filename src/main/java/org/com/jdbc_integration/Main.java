package org.com.jdbc_integration;

import org.com.jdbc_integration.dao.ProductDao;

public class Main {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
//        productDao.createTable();


//        productDao.insertRecord("Samosa",10.5,10);
//        productDao.insertRecord("Kachori",11.5,10);
//        productDao.insertRecord("Pani Puri",15.5,10);
//          productDao.getAllRecords();

//        productDao.updateRecord(3,"Vada Pao",25,10);
//        productDao.deleteRecord(4);

        productDao.getRecordById(2);



    }

}