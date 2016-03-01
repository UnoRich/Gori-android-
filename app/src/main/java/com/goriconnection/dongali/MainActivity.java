package com.goriconnection.dongali;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity implements
        SearchView.OnQueryTextListener, SearchView.OnCloseListener{


    private ExpandableListAdapter[] ExpAdapter=new ExpandableListAdapter[2]; //중앙동아리
    private ArrayList<Group>[] ExpListItems=new ArrayList[2];
    private ExpandableListView[] ExpandList=new ExpandableListView[2];


//    private ExpandableListAdapter ExpAdapter2; //애기능동아리
//    private ArrayList<Group> ExpListItems2;
//    private ExpandableListView ExpandList2;

    //Search기능 추가
    SearchView search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //중앙동아리
        ExpandList[0] = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems[0] = SetStandardGroups();//중앙동아리 리스트
        ExpAdapter[0] = new ExpandableListAdapter(MainActivity.this, ExpListItems[0]);
        ExpandList[0].setAdapter(ExpAdapter[0]);





        //  ExpandableListAdapter.groupsForSearch=ExpListItems[0];

        //애기능동아리
        ExpandList[1] = (ExpandableListView) findViewById(R.id.exp_list2);
        ExpListItems[1] = SetStandardGroups2();//애기능동아리 리스트
        ExpAdapter[1] = new ExpandableListAdapter(MainActivity.this, ExpListItems[1]);
        ExpandList[1].setAdapter(ExpAdapter[1]);



        //Search기능 추가
        SearchManager searchManager=(SearchManager)getSystemService(Context.SEARCH_SERVICE);
        search=(SearchView)findViewById(R.id.searchView);
        search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener(this);
        search.setOnCloseListener(this);


        int idd = search.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView textView = (TextView) search.findViewById(idd);
        textView.setTextColor(Color.WHITE);


        TabHost tab_host=(TabHost)findViewById(R.id.tabHost);
        tab_host.setup();


        TabHost.TabSpec ts1=tab_host.newTabSpec("중동");
        ts1.setIndicator("중앙동아리");
        ts1.setContent(R.id.tab1);
        tab_host.addTab(ts1);

        TabHost.TabSpec ts2=tab_host.newTabSpec("애동");
        ts2.setIndicator("애기능동아리");
        ts2.setContent(R.id.tab2);
        tab_host.addTab(ts2);

        TabHost.TabSpec ts3=tab_host.newTabSpec("학과");
        ts3.setIndicator("학회(준비중)");
        ts3.setContent(R.id.tab3);
        tab_host.addTab(ts3);







        ExpandList[0].setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("고대농악대")) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blogfiles.naver.net/20150314_262/piglegzzang_1426296149821d0tyY_JPEG/1-117_Page_014.jpg"));//고대 농악대
                    startActivity(i);
                }


//                if(ExpListItems[0].get(groupPosition).getItems().get(childPosition).getName().contains("고대농악대")){
//                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(ExpListItems[0].get(groupPosition).getItems().get(childPosition).getName()));//고대 농악대
//                    startActivity(i);
//                }else
//                //기악예술분과
//                String NameOfClub = ExpListItems[0].get(groupPosition).getItems().get(childPosition).getName();
                String NameOfClub=ExpAdapter[0].getChild(groupPosition, childPosition).toString();
//                if (NameOfClub.equals("─고대농악대")) {
//                    Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blogfiles.naver.net/20150314_262/piglegzzang_1426296149821d0tyY_JPEG/1-117_Page_014.jpg"));//kucc
//                    startActivity(temp);
//                }
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─고전기타부")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles8.naver.net/20150314_263/piglegzzang_1426296149974iJj9U_JPEG/1-117_Page_015.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─관악부")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles7.naver.net/20150314_150/piglegzzang_14262961501840P9u0_JPEG/1-117_Page_016.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─관현악단")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles15.naver.net/20150314_270/piglegzzang_1426296151287AsMma_JPEG/1-117_Page_017.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─국악연구회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles7.naver.net/20150314_294/piglegzzang_1426296151418UWSgC_JPEG/1-117_Page_018.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─그루터기")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles2.naver.net/20150314_289/piglegzzang_1426296151557Q1f0d_JPEG/1-117_Page_019.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─노래얼")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles4.naver.net/20150314_275/piglegzzang_1426296151747jBuNk_JPEG/1-117_Page_020.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─크림슨")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles5.naver.net/20150314_244/piglegzzang_1426296151958wevrh_JPEG/1-117_Page_021.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─JASS")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles6.naver.net/20150314_117/piglegzzang_1426296152118fvfsT_JPEG/1-117_Page_022.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─TTP")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles15.naver.net/20150314_254/piglegzzang_1426296152256rT5ee_JPEG/1-117_Page_023.jpg?type=w3"));
                    startActivity(temp);}
                //사회과학분과
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─고대문학회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles3.naver.net/20150315_178/piglegzzang_14263647169465vv1z_JPEG/1-117_Page_028.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─사람과사람")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles11.naver.net/20150315_218/piglegzzang_1426364717201hwQhF_JPEG/1-117_Page_029.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─수레바퀴")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles8.naver.net/20150315_71/piglegzzang_1426364717487XsRkC_JPEG/1-117_Page_030.jpg?type=w3"));
                    startActivity(temp);}

                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─예술비평연구회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles2.naver.net/20150315_273/piglegzzang_1426364717726Pm8rq_JPEG/1-117_Page_031.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─철학마을")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles2.naver.net/20150315_113/piglegzzang_1426364717985LxOkq_JPEG/1-117_Page_032.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─한국근현대사연구회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles4.naver.net/20150315_51/piglegzzang_1426364718193BwLbT_JPEG/1-117_Page_033.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─한국사회연구회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles6.naver.net/20150315_261/piglegzzang_1426364718437HcF3t_JPEG/1-117_Page_034.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─KURP")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles14.naver.net/20150315_237/piglegzzang_14263647186524GC0m_JPEG/1-117_Page_035.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─UNSA")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles4.naver.net/20150315_179/piglegzzang_1426364718808j1fLX_JPEG/1-117_Page_036.jpg?type=w3"));
                    startActivity(temp);}



                //사회분과
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─레인보우스쿨")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles6.naver.net/20150315_245/piglegzzang_1426364928186GaknB_JPEG/1-117_Page_040.jpg?type=w3"));//kucc
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─로타랙트")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles14.naver.net/20150315_269/piglegzzang_1426364928507cFCDO_JPEG/1-117_Page_041.jpg?type=w3"));//kucc
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─운화회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles16.naver.net/20150315_239/piglegzzang_1426364928806S9MjJ_JPEG/1-117_Page_042.jpg?type=w3"));//kucc
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─해피버블")){ Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles13.naver.net/20150315_60/piglegzzang_1426364929039MD56x_JPEG/1-117_Page_043.jpg?type=w3"));//kucc
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─호우회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles11.naver.net/20150315_154/piglegzzang_1426364929234xD3jH_JPEG/1-117_Page_044.jpg?type=w3"));//kucc
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─KURC")){ Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles5.naver.net/20150315_100/piglegzzang_1426364929435HG14X_JPEG/1-117_Page_045.jpg?type=w3"));//kucc
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─KUSA")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles2.naver.net/20150315_1/piglegzzang_1426364929704TSIFC_JPEG/1-117_Page_046.jpg?type=w3"));//kucc
                    startActivity(temp);}
                //생활문화분과
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─고대바둑사랑")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles4.naver.net/20150315_99/piglegzzang_14263651905973UJQe_JPEG/1-117_Page_050.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─뇌의주름")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles2.naver.net/20150315_97/piglegzzang_14263651912062CQR0_JPEG/1-117_Page_052.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─소믈리에")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles10.naver.net/20150315_281/piglegzzang_1426365191538FDkR5_JPEG/1-117_Page_053.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─여레")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles14.naver.net/20150315_221/piglegzzang_1426365192342m7dtk_JPEG/1-117_Page_056.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─유스호스텔")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles10.naver.net/20150315_249/piglegzzang_1426365191822lbsxm_JPEG/1-117_Page_054.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─호진회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles1.naver.net/20150315_192/piglegzzang_1426365192041jvy1G_JPEG/1-117_Page_055.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─KUCC")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles1.naver.net/20150315_288/piglegzzang_14263651909274Y0nk_JPEG/1-117_Page_051.jpg?type=w3"));
                    startActivity(temp);}
                //언어분과
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─니다미")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles14.naver.net/20150315_93/piglegzzang_1426365475386nM8P5_JPEG/1-117_Page_060.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─동수회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles13.naver.net/20150315_140/piglegzzang_1426365475933KonJ4_JPEG/1-117_Page_062.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─중국연구회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles3.naver.net/20150315_146/piglegzzang_1426365475627FprYg_JPEG/1-117_Page_061.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─한일문화연구회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles4.naver.net/20150315_51/piglegzzang_1426365476615WHkeI_JPEG/1-117_Page_064.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─ALC")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles8.naver.net/20150315_167/piglegzzang_1426365476311i9HDp_JPEG/1-117_Page_063.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─ECS")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles7.naver.net/20150315_54/piglegzzang_1426365477225OgkQq_JPEG/1-117_Page_066.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─LECA")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles15.naver.net/20150315_94/piglegzzang_1426365476929zrLRG_JPEG/1-117_Page_065.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─SIS.TIME")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles9.naver.net/20150315_264/piglegzzang_1426365477669eMnb2_JPEG/1-117_Page_067.jpg?type=w3"));
                    startActivity(temp);}
                //연행예술분과
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─극예술연구회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles8.naver.net/20150315_7/piglegzzang_1426365724293PNYkE_JPEG/1-117_Page_070.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─불아스")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles5.naver.net/20150315_276/piglegzzang_1426365724629zBnU9_JPEG/1-117_Page_071.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─미스디렉션")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles5.naver.net/20150315_148/piglegzzang_14263657249048bjqG_JPEG/1-117_Page_072.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─소울메이트")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles13.naver.net/20150315_60/piglegzzang_1426365725099VuqIz_JPEG/1-117_Page_073.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─합창단")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles9.naver.net/20150315_88/piglegzzang_14263657252998Bczo_JPEG/1-117_Page_074.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─KUDT")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles14.naver.net/20150315_93/piglegzzang_1426365725526T4f7g_JPEG/1-117_Page_075.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─LoGS")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles10.naver.net/20150315_201/piglegzzang_1426365725728PkIFO_JPEG/1-117_Page_076.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─TERRA")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles10.naver.net/20150315_249/piglegzzang_1426365725991KXWs0_JPEG/1-117_Page_077.jpg?type=w3"));
                    startActivity(temp);}
                //전시창작분과
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─그림마당")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles8.naver.net/20150315_263/piglegzzang_1426365841268FxoSb_JPEG/1-117_Page_080.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─돌빛")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles14.naver.net/20150315_285/piglegzzang_142636584166191Pek_JPEG/1-117_Page_081.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─몰라도 되는데")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles9.naver.net/20150315_264/piglegzzang_14263658418825UyIM_JPEG/1-117_Page_082.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─서화회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles15.naver.net/20150315_14/piglegzzang_1426365842053xCQkG_JPEG/1-117_Page_083.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─팝콘")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles10.naver.net/20150315_265/piglegzzang_1426365842328ToPEI_JPEG/1-117_Page_084.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─한국화회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles8.naver.net/20150315_7/piglegzzang_1426365842499O0Bbu_JPEG/1-117_Page_085.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─호영회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles4.naver.net/20150315_83/piglegzzang_14263658431775se9q_JPEG/1-117_Page_086.jpg?type=w3"));
                    startActivity(temp);}
                //종교분과
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─불교학생회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles2.naver.net/20150315_97/piglegzzang_1426366046904QFm7y_JPEG/1-117_Page_092.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─예수전도단")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles12.naver.net/20150315_11/piglegzzang_1426366047279Q6DCG_JPEG/1-117_Page_093.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─원불교학생회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles5.naver.net/20150315_212/piglegzzang_14263660476097Vhdl_JPEG/1-117_Page_094.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─젊은예수")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles12.naver.net/20150315_299/piglegzzang_1426366047951yDXXf_JPEG/1-117_Page_095.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─증산도학생회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles2.naver.net/20150315_129/piglegzzang_1426366048257kdtYp_JPEG/1-117_Page_096.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─CAM")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles12.naver.net/20150315_187/piglegzzang_1426366048553LTM0C_JPEG/1-117_Page_097.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─CCC")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles3.naver.net/20150315_210/piglegzzang_1426366048886Yl22G_JPEG/1-117_Page_098.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─ENM")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles5.naver.net/20150315_228/piglegzzang_1426366049201b5Bey_JPEG/1-117_Page_099.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─IVF")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles8.naver.net/20150315_199/piglegzzang_14263660495285XM0D_JPEG/1-117_Page_100.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─JOY")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles7.naver.net/20150315_86/piglegzzang_14263660498650gtxt_JPEG/1-117_Page_101.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─SFC")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles6.naver.net/20150315_69/piglegzzang_1426366050197jEj9G_JPEG/1-117_Page_102.jpg?type=w3"));
                    startActivity(temp);}

                //체육분과
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─궁도회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles9.naver.net/20150315_104/piglegzzang_1426366276889OKb3K_JPEG/1-117_Page_106.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─농구연구회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles6.naver.net/20150315_229/piglegzzang_1426366277311Bcfod_JPEG/1-117_Page_107.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─백구회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles8.naver.net/20150315_135/piglegzzang_14263662777968rhBe_JPEG/1-117_Page_108.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─수박도")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles1.naver.net/20150315_256/piglegzzang_14263662780893goeT_JPEG/1-117_Page_109.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─수호회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles12.naver.net/20150315_187/piglegzzang_1426366278438BgN9f_JPEG/1-117_Page_110.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─스킨스쿠버")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles8.naver.net/20150315_167/piglegzzang_1426366278750MaP18_JPEG/1-117_Page_111.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─아마추어축구부")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles2.naver.net/20150315_81/piglegzzang_1426366279148j2mA2_JPEG/1-117_Page_112.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─탁구사랑회")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles3.naver.net/20150315_66/piglegzzang_1426366279728C6Enw_JPEG/1-117_Page_114.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─택견한울")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles7.naver.net/20150315_86/piglegzzang_1426366279484qCXFa_JPEG/1-117_Page_113.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─ENTHES")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles15.naver.net/20150315_142/piglegzzang_1426366279988T9pXk_JPEG/1-117_Page_115.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[0].getChild(groupPosition, childPosition).getName().contains("─KUBC")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles6.naver.net/20150315_5/piglegzzang_1426366280235EUzmH_JPEG/1-117_Page_116.jpg?type=w3"));
                    startActivity(temp);}
//                if(NameOfClub.equals("─")){Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
//                    startActivity(temp);}


                return false;
            }});
        ExpandList[1].setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //문화체육분과
                //               String NameOfClub=ExpListItems[1].get(groupPosition).getItems().get(childPosition).getName();



                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─ICCUS")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles3.naver.net/20150317_274/piglegzzang_1426537831979jhJSU_JPEG/iccus.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─TRUSS")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles8.naver.net/20150317_39/piglegzzang_1426537829509GBpxe_JPEG/truss.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─SOULMATE")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles1.naver.net/20150317_272/piglegzzang_1426537826862A6Hth_JPEG/%BC%D2%BF%EF%B8%DE%C0%CC%C6%AE.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─암실")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles15.naver.net/20150317_142/piglegzzang_142653782614122rMe_JPEG/%BE%CF%BD%C7.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─호농회")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles14.naver.net/20150317_109/piglegzzang_14265378223538kDAB_JPEG/%C8%A3%B3%F3%C8%B8.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─티그리스")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles14.naver.net/20150317_45/piglegzzang_1426537823606wSE1h_JPEG/%C6%BC%B1%D7%B8%AE%BD%BA.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─햇빛촌")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles10.naver.net/20150317_249/piglegzzang_1426537822618VkcQD_JPEG/%C7%DE%BA%FB%C3%CC.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─데드라인즈")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles13.naver.net/20150317_220/piglegzzang_14265378279343RQzv_JPEG/%B5%A5%B5%E5%B6%F3%C0%CE%C1%EE.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─열그림")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles3.naver.net/20150317_50/piglegzzang_1426537824816BOg7Y_JPEG/%BF%AD%B1%D7%B8%B2.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─하날다래")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles3.naver.net/20150317_2/piglegzzang_1426537823240uxwO1_JPEG/%C7%CF%B3%AF%B4%D9%B7%A1.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("온보이싱")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles10.naver.net/20150317_185/piglegzzang_1426537824407GqtFF_JPEG/%BF%C2%BA%B8%C0%CC%BD%CC.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─애기능 불교학생회")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles1.naver.net/20150317_16/piglegzzang_1426537825797clyS8_JPEG/%BE%D6%B1%E2%BA%D2.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─복음자리")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles9.naver.net/20150317_248/piglegzzang_14265378272679aAm0_JPEG/%BA%B9%C0%BD%C0%DA%B8%AE.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─1905")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles12.naver.net/20150317_75/piglegzzang_1426537832341bOCwo_JPEG/1905.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─노래마당")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles14.naver.net/20150317_29/piglegzzang_14265378282637ALCF_JPEG/%B3%EB%B7%A1%B8%B6%B4%E7.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─고대풍물패")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles8.naver.net/20150317_231/piglegzzang_1426537828536joOEA_JPEG/%B0%ED%B4%EB%C7%B3%B9%B0%C6%D0.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─KUARC")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles9.naver.net/20150317_24/piglegzzang_1426537830042gr9B8_JPEG/kuarc.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─KAsimov")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles2.naver.net/20150317_49/piglegzzang_14265378310472blug_JPEG/kasimov.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─IYF")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles7.naver.net/20150317_294/piglegzzang_1426537831468luaQd_JPEG/iyf.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─KUAAA")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles10.naver.net/20150317_57/piglegzzang_1426537830532Jm3m0_JPEG/kuaaa.jpg?type=w3"));
                    startActivity(temp);}
                if (ExpAdapter[1].getChild(groupPosition, childPosition).getName().contains("─Deluxe")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse("http://postfiles12.naver.net/20150317_107/piglegzzang_1426537833493pRhg4_JPEG/deluxe.jpg?type=w3"));
                    startActivity(temp);}
//                if(NameOfClub.equals("─")) {Intent temp = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
//                    startActivity(temp);}


                return false;
            }
        });

    }



    public int GetPixelFromDips(float pixels) {//화살표 위치설정
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);

    }

    @Override   //화살표 위치설정
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            ExpandList[0].setIndicatorBounds(width - GetPixelFromDips(35), width - GetPixelFromDips(5));
        } else {
            ExpandList[0].setIndicatorBoundsRelative(width - GetPixelFromDips(35), width - GetPixelFromDips(5));
        }
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            ExpandList[1].setIndicatorBounds(width - GetPixelFromDips(35), width - GetPixelFromDips(5));
        } else {
            ExpandList[1].setIndicatorBoundsRelative(width - GetPixelFromDips(35), width - GetPixelFromDips(5));
        }
    }

    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = { "기악예술분과", "사회과학분과", "사회분과", "생활문화분과",
                "언어분과", "연행예술분과", "전시창작분과", "종교분과","체육분과" };

        String country_names[] = {"─고대농악대","─고전기타부","─관악부","─관현악단","─국악연구회","─그루터기","─노래얼","─크림슨","─JASS","─TTP",
                "─고대문학회","─사람과사람","─수레바퀴","─예술비평연구회","─철학마을","─한국근현대사연구회","─한국사회연구회","─KURP","─UNSA",
                "─레인보우스쿨","─로타랙트","─운화회","─해피버블","─호우회", "─KURC","─KUSA",
                "─고대바둑사랑","─뇌의주름","─소믈리에","─여레","─유스호스텔","─호진회","─KUCC",
                "─니다미","─동수회","─중국연구회","─한일문화연구회","─ALC","─ECS","─LECA","─SIS.TIME",
                "─극예술연구회","─불아스","─미스디렉션","─소울메이트","─합창단","─KUDT","─LoGS","─TERRA",
                "─그림마당","─돌빛","─몰라도 되는데","─서화회","─팝콘","─한국화회","─호영회",
                "─불교학생회","─예수전도단","─원불교학생회","─젊은예수","─증산도학생회","─CAM","─CCC","─ENM","─IVF","─JOY","─SFC",
                "─궁도회","─농구연구회","─백구회","─수박도","─수호회","─스킨스쿠버","─아마추어축구부","─탁구사랑회","─택견한울","─ENTHES","─KUBC"};

        int Images[] = { R.drawable.giakk, R.drawable.socialscience,
                R.drawable.social, R.drawable.life_culture, R.drawable.linguistic,
                R.drawable.art, R.drawable.creativity, R.drawable.religion, R.drawable.sports};

        String child_keywords[]={"#풍물 #농악 #상시모집 #누구나","#통기타 #클래식 #상시모집 #누구나","#관악기 #상시모집 #누구나","#관현악 #현악기 #관악기 #상시모집 #누구나","#국악 #가야금 #거문고 #상시모집 #누구나","#통기타 #학기초 #누구나","#노래 #밴드 #학기초 #신입생만",
                "#락밴드 #학기초 #신입생만","#재즈 #상시모집 #누구나","#피아노 #상시모집 #신입생만",
                "#문학 #책 #상시모집 #누구나","#성소수자 #상시모집 #누구나","#정치경제학 #상시모집 #누구나","#예술 #음악 #문학 #연극 #영화 #철학 #상시모집 #누구나","#철학 #인문학 #상시모집 #누구나","#역사 #근현대사 #상시모집 #누구나","#사회과학 #상시모집 #누구나","#진리탐구 #철학 #상시모집 #누구나","#유엔 #토론 #상시모집 #신입생만",
                "#인권 #교육봉사 #학기초 #누구나","#봉사 #학기초 #신입생만","#교육봉사 #학기초 #신입생만","#자원활동 #봉사 #학기초 #누구나","#봉사 #학기초 #누구나","#적십자봉사 #학기초 #신입생만","#봉사 #상시모집 #신입생만",
                "#바둑 #상시모집 #누구나","#보드게임 #상시모집 #누구나","#소믈리에 #와인 #학기초 #누구나","#여가 #레크레이션 #상시모집 #누구나","#여행 #상시모집 #누구나","#영화 #상시모집 #누구나","#컴퓨터 #학기초 #누구나",
                "#불어 #프랑스 #상시모집 #누구나","#한문 #상시모집 #누구나","#중국어 #상시모집 #누구나","#일본문화 #상시모집 #누구나","#영어 #학기초 #누구나","#영어 #상시모집 #누구나","#외국어 #교환학생 #학기초 #누구나",
                "#영어 #시사 #상시모집 #누구나",
                "#연극 #학기초 #누구나","#댄스스포츠 #상시모집 #누구나","#마술 #상시모집 #누구나","#뮤지컬 #학기초 #누구나","#합창 #상시모집 #누구나","#스트릿댄스 #학기초 #누구나","#아카펠라 #학기초 #누구나","#흑인음악 #힙합 #학기초 #누구나",
                "#만화 #그림 상시모집 #누구나","#영화제작 #상시모집 #누구나","#문화정보 #상시모집 #누구나","#서예 서양화 #학기초 #누구나","#광고제작 #상시모집 #누구나","#한국화 #미술 #상시모집 #누구나","#사진 #카메라 #학기초 #누구나",
                "#종교 #불교 #상시모집 #누구나","#종교 #기독교 #상시모집 #누구나","#종교 #원불교 #상시모집 #누구나","#종교 #천주교 #상시모집 #누구나","#종교 #증산도 #우주 #상시모집 #누구나","#종교 #천주교 #상시모집 #누구나","#종교 #기독교 #상시모집 #누구나","#종교 #그리스도 #기독교 #상시모집 #누구나","#종교 #기독교 #상시모집 #누구나","#종교 #기독교 #상시모집 #누구나","#종교 #기독교 #상시모집 #누구나",
                "#활 #궁도 #양궁 #상시모집 #누구나","#농구 #상시모집 #누구나","#야구 #상시모집 #누구나","#운동 #무술 #상시모집 #누구나","#수영 #봉사 #상시모집 #누구나","#수영 #스킨스쿠버 #상시모집 #신입생만","#축구 #상시모집 #누구나","#탁구 #상시모집 #누구나","#택견 #무예 #상시모집 #누구나","#스쿼시 #상시모집 #누구나","#배드민턴 #상시모집 #누구나"};

//        String child_URI[]={"0-0","0-1","0-2","0-3","0-4","0-5","0-6","0-7","0-8","0-9",
//                "1-0","1-1","1-2","1-3","1-4","1-5","1-6","1-7","1-8",
//                "http://postfiles6.naver.net/20150315_245/piglegzzang_1426364928186GaknB_JPEG/1-117_Page_040.jpg?type=w3","http://postfiles14.naver.net/20150315_269/piglegzzang_1426364928507cFCDO_JPEG/1-117_Page_041.jpg?type=w3","http://postfiles16.naver.net/20150315_239/piglegzzang_1426364928806S9MjJ_JPEG/1-117_Page_042.jpg?type=w3","http://postfiles13.naver.net/20150315_60/piglegzzang_1426364929039MD56x_JPEG/1-117_Page_043.jpg?type=w3","http://postfiles11.naver.net/20150315_154/piglegzzang_1426364929234xD3jH_JPEG/1-117_Page_044.jpg?type=w3","http://postfiles5.naver.net/20150315_100/piglegzzang_1426364929435HG14X_JPEG/1-117_Page_045.jpg?type=w3","http://postfiles2.naver.net/20150315_1/piglegzzang_1426364929704TSIFC_JPEG/1-117_Page_046.jpg?type=w3",
//                "3-0","3-1","3-2","3-3","3-4","3-5","3-6",
//                "4-0","4-1","4-2","4-3","4-4","4-5","4-6","4-7",
//                "5-0","5-1","5-2","5-3","5-4","5-5","5-6","5-7",
//                "6-0","6-1","6-2","6-3","6-4","6-5","6-6",
//                "7-0","7-1","7-2","7-3","7-4","7-5","7-6","7-7","7-8","7-9","7-10","#상시모집 #필수활동1학기 #누구나 #신입생 #복학생 #학번제한X #활 #양궁","#상시모집 #누구나 #월/금 정기모임 #농구 #운동 #교내리그출전 #교환학생 #외국인 #여자선수","#상시모집 #누구나 #야구 #필수활동학기X #복학생 #신입생",
//                "","","","","","","",""};
        ArrayList<Group> list1 = new ArrayList<Group>();

        ArrayList<Child> ch_list1;

        int size[]={10,9,7,7,8,8,7,11,11};
        int numOfGroup=9,beginSize=0;//beginSize는 첫번째그룹, size[0]은 두번째그룹부터
        int j = 0,a=0;

        for (int i=0;i<numOfGroup;i++) {
            ch_list1 = new ArrayList<Child>();
            Group gru = new Group(group_names[i],ch_list1,Images[i]);
            gru.setImage(Images[i]);
            gru.setName(group_names[i]);

            beginSize=beginSize+size[a];
            //ch_list = new ArrayList<Child>();
            for (; j < beginSize; j++) {
                Child ch = new Child();
                ch.setName(country_names[j]);
                ch.setKeywords(child_keywords[j]);
                //  ch.setURI(child_URI[j]);
                ch_list1.add(ch);

            }
            gru.setItems(ch_list1);
            list1.add(gru);
            a=a+1;

        }

        return list1;
    }
    public ArrayList<Group> SetStandardGroups2() {

        String group_names[] = { "문화체육분과", "사회종교분과", "연행예술분과", "학술연구분과" };

        String country_names[] = {"─암실","─호농회","─Deluxe","─티그리스(Tigris)","─데드라인즈","─열그림",
                "─IYF","─복음자리","─햇빛촌","─ICCUS","─애기능 불교학생회",
                "─하날다래(탈패)","─TRUSS","─1905","─노래마당","─SOULMATE","─고대풍물패","─OV(온보이싱)",
                "─KAsimov","─KUARC","─KUAAA"};

        int Images[] = { R.drawable.sports2, R.drawable.social2,
                R.drawable.art2, R.drawable.research2};

        String child_keywords[]={"#흑백사진 #상시모집 #누구나","#농구 #상시모집 #누구나","#게임 #오락 #상시모집 #누구나","#야구 #상시모집 #누구나","#야구 #상시모집 #누구나","#그림 #미술 #상시모집 #누구나",
                "#기독교 #해외봉사 #학기초 #누구나","#기독교 #상시모집 #누구나","#교육봉사 #학기초 #누구나","#워크캠프 #학기초 #누구나","#휴식 #불교 #명상 #상시모집",
                "#탈춤 #풍물놀이 #상시모집 #누구나","#밴드 #상시모집","#밴드 #락 #학기초 #누구나","#노래패 #학기초 #신입생만","#노래 #보컬 #랩퍼 #학기초 #누구나","#풍물 #농악 #사물놀이 #상시모집 #신입생만","#성우 #더빙 #학기초 #누구나",
                "#지능로봇 #상시모집 #누구나","#전파통신 #상시모집 #누구나","#천문회 #천체관측 #상시모집 #누구나"};

//        String child_URI[]={"http://blogfiles.naver.net/20150314_262/piglegzzang_1426296149821d0tyY_JPEG/1-117_Page_014.jpg","0-1","0-2","0-3","0-4","0-5",
//                "1-0","1-1","1-2","1-3","1-4",
//                "2-0","2-1","2-2","2-3","2-4","2-5","2-6",
//                "3-0","3-1","http://www.naver.com/"};

        ArrayList<Group> list = new ArrayList<Group>();
        ArrayList<Child> ch_list2;


        int size[]={6,5,7,3};
        int numOfGroup=4,beginSize=0;//beginSize는 첫번째그룹, size[0]은 두번째그룹부터
        int j = 0,a=0;

        for (int i=0;i<numOfGroup;i++) {
            ch_list2 = new ArrayList<Child>();
            Group gru = new Group(group_names[i],ch_list2, Images[i] );

            // Group gru = new Group();
            gru.setImage(Images[i]);
            gru.setName(group_names[i]);

            beginSize=beginSize+size[a];

            for (; j < beginSize; j++) {
                Child ch = new Child();
                ch.setName(country_names[j]);
                ch.setKeywords(child_keywords[j]);
                // ch.setURI(child_URI[j]);
                ch_list2.add(ch);

            }
            gru.setItems(ch_list2);
            list.add(gru);
            a=a+1;
        }
        return list;
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void expandAll() {                   ///List 출력하는 부분
        for (int i = 0; i < 2; i++) {
            int count = ExpAdapter[i].getGroupCount();
            for (int j = 0; j < count; j++)
                ExpandList[i].expandGroup(j);
        }
    }


    @Override
    public boolean onClose() {

        for(int i=0;i<2;i++) {
            ExpAdapter[0].filterData("");// 공백으로 필터 초기화잼ㅋ
            expandAll();  //처음 출력
        }
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        ExpAdapter[0].filterData(query);
        ExpAdapter[1].filterData(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        ExpAdapter[0].filterData(query);
        ExpAdapter[1].filterData(query);
        expandAll();   // 바뀐 쿼리에 대해 출력 요청
        return false;
    }
}
