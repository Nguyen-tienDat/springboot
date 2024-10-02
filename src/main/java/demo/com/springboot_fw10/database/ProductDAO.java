package demo.com.springboot_fw10.database;

import demo.com.springboot_fw10.controllers.ProductController;
import demo.com.springboot_fw10.models.Product;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
@Component
public class ProductDAO extends Database{
    public ProductDAO() {
        getConnection();
    }
public ArrayList<Product> list() {
        try {
            String sql = "SELECT * FROM product";
            ArrayList<Product> list = new ArrayList<>();
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setCategory(rs.getString("category"));
                list.add(product);
            }
            return list;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
}
public Product get(int id) {
        Product product = new Product();
try{
    String sql = "SELECT * FROM product WHERE id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery(sql);
    while(rs.next()) {
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        product.setCategory(rs.getString("category"));
        return product;
    }
}catch (Exception e) {
    e.printStackTrace();
}
return product;
}
public boolean remove(int id) {
try{
    String sql = "DELETE FROM product WHERE id = "+id;
    connection.createStatement().executeUpdate(sql);
    return true;
}catch (Exception e){
    e.printStackTrace();
}
return false;
}
public boolean update(Product product) {
        try{
            PreparedStatement ps  = connection.prepareStatement("UPDATE products SET name = ?, price = ?, category=? WHERE id = ?");
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3,product.getCategory());
            ps.setInt(4, product.getId());
            ps.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
}
public boolean add(Product product) {
    try{
        String sql = "INSERT INTO product (name, price, category) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        ps.setString(3, product.getCategory());
        int rowUpdate = ps.executeUpdate();

        return rowUpdate > 0;
    }catch (Exception e){
        e.printStackTrace();
    }
    return false;
}

}
