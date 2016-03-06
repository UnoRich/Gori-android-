package com.goriconnection.dongali;

import java.util.ArrayList;

public class Group {
    private String Name;
    private ArrayList<Child> Items;
    private int Image;

    public Group(String name, ArrayList<Child> Items,int image){ //searchview 때문에 어쩔 수 없이 오버라이딩함
        super();
        this.Name=name;
        this.Items=Items;
        this.Image=image;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public ArrayList<Child> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Child> Items) {
        this.Items = Items;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int Image) {
        this.Image = Image;
    }
}
