package io.realm;


public interface ProductRealmProxyInterface {
    public String realmGet$id();
    public void realmSet$id(String value);
    public String realmGet$productName();
    public void realmSet$productName(String value);
    public String realmGet$unit();
    public void realmSet$unit(String value);
    public String realmGet$quantum();
    public void realmSet$quantum(String value);
    public String realmGet$price();
    public void realmSet$price(String value);
    public String realmGet$total();
    public void realmSet$total(String value);
    public boolean realmGet$addedToCart();
    public void realmSet$addedToCart(boolean value);
}
