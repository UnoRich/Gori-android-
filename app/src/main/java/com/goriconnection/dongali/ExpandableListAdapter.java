package com.goriconnection.dongali;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 황세희 on 2015-03-13.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private  ArrayList<Group> groups;
    private ArrayList<Group> childList;




    public ExpandableListAdapter(Context context, ArrayList<Group> groups) {
        this.context = context;
        this.groups = new ArrayList<Group>();
        this.groups.addAll(groups);
        this.childList=new ArrayList<Group>();
        this.childList.addAll(groups);
      //  this.groupsForSearch=groupsForSearch;
    }

    @Override
    public Child getChild(int groupPosition, int childPosition) {
        ArrayList<Child> chList = groups.get(groupPosition).getItems();
        return chList.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        Child child = (Child) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_item, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.country_name);
        TextView key=(TextView)convertView.findViewById(R.id.keywords);


        tv.setText(child.getName().toString());
        key.setText(child.getKeywords().toString());


        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
     //   ArrayList<Child> chList = groups.get(groupPosition).getItems();
     //   return childList.size();
        return this.groups.get(groupPosition).getItems().size();


    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        Group group = (Group) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.group_item, null);
        }


        TextView tv = (TextView) convertView.findViewById(R.id.group_name);
        ImageView iv = (ImageView) convertView.findViewById(R.id.flag);

        tv.setText(group.getName());
        iv.setImageResource(group.getImage());
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    public void filterData(String query){   //http://www.mysamplecode.com/2012/11/android-expandablelistview-search.html    에서 발취함

        query = query.toLowerCase(); //continentList==groups
       // groupsForSearch=groups;
        Log.v("ExpandableListAdapter", String.valueOf(groups.size()));
        groups.clear();

        if(query.isEmpty()){
            groups.addAll(childList);
        }
        else {

            for(Group group: childList){

                ArrayList<Child> items = group.getItems(); //countryList==items
                ArrayList<Child> newList = new ArrayList<Child>();
                for(Child child: items){
                    if(child.getName().toLowerCase().contains(query) || child.getName().toLowerCase().contains(query) || child.getKeywords().toLowerCase().contains(query)){
                        newList.add(child);
                    }
                }
                if(newList.size() > 0){
                    Group nGroup = new Group(group.getName(),newList,group.getImage());
                    groups.add(nGroup);
                }
            }
        }

        Log.v("ExpandableListAdapter", String.valueOf(groups.size()));
       notifyDataSetChanged();


       // groupsForSearch2=groups;


    }
}
