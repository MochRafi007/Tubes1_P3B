//package com.example.m0317073.Adapder;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import com.example.m0317073.DataBase.DataBaseHelper;
//import com.example.m0317073.Model.Menu;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MenuDataSource {
//    private SQLiteDatabase db;
//    private DataBaseHelper helper;
//
//    private ContentValues createForm(Menu menu)
//    {
//        ContentValues cv = new ContentValues();
//        cv.put("nama_menu",menu.getNama_menu());
//        cv.put("tag",menu.getTag());
//        cv.put("bahan",menu.getBahan());
//        cv.put("langkah_masak",menu.getLangkah_masak());
//        cv.put("tersedia",menu.getTersedia());
//
//        return cv;
//    }
//
//    public MenuDataSource(Context context)
//    {
//        helper = new DataBaseHelper(context);
//    }
//
//    void open()
//    {
//        db = helper.getWritableDatabase();
//    }
//
//    void close()
//    {
//        helper.close();
//    }
//
//    public void addStudent(Menu menu)
//    {
//        ContentValues cv = createForm(menu);
//        db.insert("makeMenu",null,cv);
//    }
//
//    public List<Menu> getAll()
//    {
//        Cursor cursor = db.rawQuery("SELECT * from makeMenu",new String[]{});
//
//        List<Menu> makananList = new ArrayList<>();
//
//        cursor.moveToFirst();
//        while(!cursor.isAfterLast())
//        {
//            makananList.add(cursorToMenu(cursor));
//            cursor.moveToNext();
//        }
//        return makananList;
//    }
//
//    private Menu cursorToMenu (Cursor cursor)
//    {
//        Menu menu =  new Menu();
//
//        menu.setId(cursor.getLong(0));
//        menu.setNama_menu(cursor.getString(1));
//        menu.setTag(cursor.getString(2));
//        menu.setBahan(cursor.getString(3));
//        menu.setLangkah_masak(cursor.getString(4));
//        menu.setTersedia(cursor.getString(5));
//
//        return menu;
//
//
//    }
//
//    public ArrayList<Menu> findBy(String nameToSearch)
//    {
//        String nama = "SELECT * FROM makeMenu WHERE nama_menu LIKE ?";
//        String [] params =
//                {
//                        "%"+nameToSearch+"%"
//
//                };
//
//        open();
//        Cursor cursor = db.rawQuery(nama,params);
//        ArrayList<Menu> menuList = new ArrayList<>();
//        while (cursor.moveToNext())
//        {
//            Menu menu = cursorToMenu(cursor);
//            menuList.add(menu);
//        }
//        cursor.close();
//        close();
//
//        return menuList;
//    }
//
//    public void updateStudent(Menu menu)
//    {
//        ContentValues cv = createForm(menu);
//        String[] param={String.valueOf(menu.getId())};
//        open();
//        db.update("student",cv,"id=?",param);
//        close();
//    }
//
//    public void deleteStudent (Menu menu)
//    {
//        ContentValues cv = createForm(menu);
//        String[] param = {String.valueOf(menu.getId())};
//        open();
//        db.delete("Calculate","id=?",param);
//        close();
//    }
//}
