package com.example.minami;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReciteActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    public static UserHelp userHelp;
    private MyOpenHelp myOpenHelp;
    private WordHelp wordHelp2 = new WordHelp();
    private int learn_number ;

    private TextView en,judge;
    private Button b1,b2,b3,b4,btn_sound,next;

    private TextToSpeech mtts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recite);

        myOpenHelp = userHelp.getOpenHelp();
        intitts();

        b1= findViewById(R.id.btn_recite_1);
        b2= findViewById(R.id.btn_recite_2);
        b3= findViewById(R.id.btn_recite_3);
        b4= findViewById(R.id.btn_recite_4);
        btn_sound =findViewById(R.id.btn_recite_sound);
        next = findViewById(R.id.btn_recite_next);

        en = findViewById(R.id.tv_recite_en);
        judge = findViewById(R.id.tv_recite_judge);

        learn_number = query_learn_num();
        initbook();

        dbalter(query()-learn_number,userHelp.getUsername());

        en.setText(wordHelp2.getCet4en()[query()]);
        sound(wordHelp2.getCet4en()[query()]);
        btn1true(randomCommon(0,69,3));


        btn_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound(wordHelp2.getCet4en()[query()]);
                //dbalter(10,userHelp.getUsername());
                //Toast.makeText(ReciteActivity.this,userHelp.getUsername(),Toast.LENGTH_SHORT).show();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                i= i+1;
//                en.setText(cet_4_en[i]);
//                judge.setText("");
//                int flag = i;
//                dbalter(flag,userHelp.getUsername());
                judge.setText("");

                if(query()< wordHelp2.getCet4en().length){
                    int i=query()+1;

                    en.setText(wordHelp2.getCet4en()[i]);
                    dbalter(i,userHelp.getUsername());
                }else if(query()== wordHelp2.getCet4en().length){
                    //Toast.makeText(ReciteActivity.this,"end",Toast.LENGTH_SHORT).show();
                }

                if(query()%learn_number==0&&query()!=0){

                    en.setText(wordHelp2.getCet4en()[query()-1]);
                    mydialog();


                }else{
                    int randomtrue = (int) (Math.random() * 4+1);

                    switch (randomtrue){
                        case 1:
                            int[] ran1 = randomCommon(0,69,4);
                            btn1true(ran1);
                            break;
                        case 2:
                            int[] ran2 = randomCommon(0,69,5);
                            btn2true(ran2);
                            break;
                        case 3:
                            int[] ran3 = randomCommon(0,69,6);
                            btn3true(ran3);
                            break;
                        case 4:
                            int[] ran4 = randomCommon(0,69,7);
                            btn4true(ran4);
                            break;
                    }

                }

            }
        });
    }


    private void btn1true(int[] randommun){

        b1.setText(wordHelp2.getCet4cn()[query()]);
        sound(wordHelp2.getCet4en()[query()]);
        b2.setText(wordHelp2.getCet4cn()[randommun[0]]);
        b3.setText(wordHelp2.getCet4cn()[randommun[1]]);
        b4.setText(wordHelp2.getCet4cn()[randommun[2]]);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });

    }
    private void btn2true(int[] randommun){

        b2.setText(wordHelp2.getCet4cn()[query()]);
        sound(wordHelp2.getCet4en()[query()]);
        b1.setText(wordHelp2.getCet4cn()[randommun[0]]);
        b3.setText(wordHelp2.getCet4cn()[randommun[1]]);
        b4.setText(wordHelp2.getCet4cn()[randommun[2]]);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });

    }
    private void btn3true(int[] randommun){

        b3.setText(wordHelp2.getCet4cn()[query()]);
        sound(wordHelp2.getCet4en()[query()]);
        b1.setText(wordHelp2.getCet4cn()[randommun[0]]);
        b2.setText(wordHelp2.getCet4cn()[randommun[1]]);
        b4.setText(wordHelp2.getCet4cn()[randommun[2]]);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });

    }
    private void btn4true(int[] randommun){

        b4.setText(wordHelp2.getCet4cn()[query()]);
        sound(wordHelp2.getCet4en()[query()]);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });
        b1.setText(wordHelp2.getCet4cn()[randommun[0]]);
        b2.setText(wordHelp2.getCet4cn()[randommun[1]]);
        b3.setText(wordHelp2.getCet4cn()[randommun[2]]);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judge.setText("??????");
            }
        });

    }

    public int[] randomCommon(int min, int max, int n){
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while(count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(num == result[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count] = num;
                count++;
            }
        }
        return result;
    }

    private void intitts(){
        mtts = new TextToSpeech(this,this);
        mtts.setPitch(0.7f);
        mtts.setSpeechRate(1.0f);

    }

    private void sound(String text){

        mtts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }

    private void mydialog(){
        AlertDialog aldg;
        AlertDialog.Builder adBd=new AlertDialog.Builder(ReciteActivity.this);
        adBd.setTitle("?????????");

        adBd.setMessage("???????????????????????????");
        adBd.setPositiveButton("???????????????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = null;
                intent = new Intent(ReciteActivity.this, InterfaceActivity.class);
                startActivity(intent);
            }
        });

        aldg=adBd.create();
        aldg.show();
    }

    private void dbalter(int i,String username){
        SQLiteDatabase db = myOpenHelp.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("flag",i);
        db.update("User",values,"name=?",new String[] {username});

        values.clear();
    }

//    private int query(String username){
//        int flag2=10;
//        SQLiteDatabase db = myOpenHelp.getWritableDatabase();
//        Cursor cursor = db.query("User",new String[] {"flag"},"name=?",new String[] {username},
//                "flag",null,null);
//
//        if(cursor.moveToFirst()){
//            do{
//                int flag = cursor.getInt(0);
//                flag2 =flag;
//            }while (cursor.moveToNext());
//        }
//        cursor.close();
//        return flag2;
//    }

    public int query(){

        SQLiteDatabase db = myOpenHelp.getWritableDatabase();
        Cursor cursor = db.query("User",new String[]{"flag","word_book"},"name=?",new String[]{userHelp.getUsername()},
                null,null,null);
        cursor.moveToFirst();
        int flag= cursor.getInt(0);

        cursor.close();
        return flag;
    }

    public void initbook(){
        if(querybook()==1){
            wordHelp2.setCet4cn(bookcn1);
            wordHelp2.setCet4en(booken1);
        }else if(querybook()==2){
            wordHelp2.setCet4cn(bookcn2);
            wordHelp2.setCet4en(booken2);
        }else if(querybook()==3){
            wordHelp2.setCet4cn(bookcn3);
            wordHelp2.setCet4en(booken3);
        }else{

        }
    }

    public int querybook(){

        SQLiteDatabase db = myOpenHelp.getWritableDatabase();
        Cursor cursor = db.query("User",new String[]{"flag","word_book"},"name=?",new String[]{userHelp.getUsername()},
                null,null,null);
        cursor.moveToFirst();
        int flag= cursor.getInt(1);

        cursor.close();
        return flag;
    }

    public int query_learn_num(){

        SQLiteDatabase db = myOpenHelp.getWritableDatabase();
        Cursor cursor = db.query("User",new String[]{"flag","word_book","learn_num"},"name=?",new String[]{userHelp.getUsername()},
                null,null,null);
        cursor.moveToFirst();
        int flag= cursor.getInt(2);

        cursor.close();
        return flag;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent intent = null;
            intent = new Intent(ReciteActivity.this, InterfaceActivity.class);
            startActivity(intent);
            return false;
        }else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private String[] booken1 = {"gramme",
            "congress",
            "bump",
            "stroke",
            "ingredient",
            "arbitrary",
            "pinch",
            "exploit",
            "action",
            "ash",
            "rope",
            "bulk",
            "strengthen",
            "independent",
            "board",
            "recall",
            "studio",
            "grave",
            "eve",
            "formal",
            "absorb",
            "sensitive",
            "ability",
            "fairy",
            "talent",
            "comparison",
            "stuff",
            "brow",
            "infer",
            "invasion",
            "grand",
            "stress",
            "journalist",
            "supply",
            "penetrate",
            "subject",
            "pole",
            "raw",
            "embassy",
            "carpenter",
            "appropriate",
            "socialist",
            "protein",
            "enlarge",
            "inherit",
            "chemist",
            "conflict",
            "drain",
            "architecture",
            "charity",
            "entitle",
            "subsequent",
            "span",
            "pea",
            "instruct",
            "spite",
            "slender",
            "automobile",
            "behavior",
            "envy",
            "substance",
            "contest",
            "spit",
            "mutual",
            "dorm",
            "substantial",
            "meanwhile",
            "desire",
            "conviction"
    };

    private String[] bookcn1 ={"???",
            "??????????????????????????????",
            "???????????????????????????",
            "?????????????????????????????????????????????????????????????????????????????????????????????????????????",
            "????????????????????????????????????????????????",
            "???????????????????????????",
            "?????????",
            "????????????????????????",
            "????????????????????????????????????????????????",
            "???",
            "?????????",
            "????????????????????????",
            "???????????????",
            "??????????????????????????????????????????????????????",
            "???????????????????????????????????????????????????????????????",
            "?????????????????????????????????????????????",
            "??????????????????????????????????????????????????????",
            "j.?????????",
            "???????????????????????????",
            "????????????????????????",
            "?????????????????????????????????????????????????????????????????????",
            "???????????????????????????????????????????????????????????????????????????",
            "?????????????????????????????????",
            "?????????????????????",
            "????????????????????????",
            "?????????????????????????????????",
            "???????????????",
            "??????????????????",
            "????????????????????????",
            "????????????????????????",
            "????????????????????????????????????????????????????????????????????????",
            "????????????????????????????????????",
            "??????????????????????????????",
            "???????????????",
            "???????????????????????????????????????????????????",
            "????????????????????????",
            "???????????????????????????",
            "?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????",
            "?????????????????????????????????",
            "???????????????",
            "?????????????????????",
            "???????????????",
            "?????????",
            "????????????????????????",
            "??????",
            "?????????????????????",
            "??????????????????????????????????????????",
            "???????????????",
            "???????????????????????????????????????",
            "?????????????????????",
            "???????????????????????????",
            "?????????????????????",
            "?????????????????????",
            "??????",
            "??????????????????????????????",
            "????????????????????????",
            "?????????????????????????????????????????????",
            "??????????????????",
            "????????????????????????",
            "?????????????????????????????????",
            "???????????????????????????????????????????????????",
            "???????????????",
            "??????????????????",
            "?????????????????????",
            "??????",
            "?????????????????????????????????????????????????????????????????????",
            "????????????",
            "?????????n.???????????????",
            "????????????????????????????????????????????????????????????"
    };

    private String[] booken2 = {
            "definite",
            "cautious",
            "prayer",
            "nest",
            "domestic",
            "chest",
            "airline",
            "rebel",
            "satisfactory",
            "stem",
            "render",
            "object",
            "gardener",
            "shrink",
            "parade",
            "rumour",
            "rug",
            "establish",
            "primarily",
            "kindness",
            "breast",
            "sticky",
            "boost",
            "fund",
            "incredible",
            "abroad",
            "detective",
            "stiff",
            "stimulate",
            "fame",
            "consume",
            "accelerate",
            "lightning",
            "sting",
            "bound",
            "rouse",
            "cultivate",
            "material",
            "personnel",
            "display",
            "particle",
            "frog",
            "impression",
            "biology",
            "drunk",
            "barrier",
            "stock",
            "fisherman",
            "politician",
            "royal",
            "barber",
            "stocking",
            "delegate",
            "highlight",
            "depression",
            "signature",
            "atmosphere",
            "evaluate",
            "rescue",
            "personality",
            "latter",
            "parliament",
            "input",
            "partial",
            "loyalty",
            "calendar",
            "overlook",
            "debate",
            "stoop"
    };

    private String[] bookcn2 = {"?????????????????????",
            "???????????????????????????",
            "??????????????????????????????????????????",
            "?????????v.??????",
            "?????????????????????????????????",
            "????????????????????????",
            "?????????????????????",
            "????????????????????????",
            "???????????????",
            "?????????????????????",
            "??????????????????????????????????????????",
            "????????????????????????????????????????????????????????????",
            "???????????????",
            "???????????????????????????????????????",
            "???????????????",
            "???????????????",
            "?????????",
            "?????????????????????????????????",
            "??????????????????",
            "???????????????",
            "????????????????????????",
            "?????????????????????????????????",
            "????????????????????????????????????????????????????????????",
            "???????????????",
            "??????????????????????????????????????????????????????????????????????????????",
            "?????????????????????????????????",
            "?????????????????????",
            "?????????????????????????????????????????????????????????????????????????????????????????????",
            "????????????????????????",
            "???????????????",
            "?????????????????????????????????????????????",
            "?????????????????????",
            "??????",
            "???????????????????????????????????????",
            "????????????????????????",
            "????????????????????????",
            "???????????????????????????????????????",
            "???????????????",
            "???????????????",
            "????????????????????????",
            "????????????????????????????????????????????????",
            "???",
            "???????????????",
            "?????????????????????",
            "??????????????????",
            "?????????????????????????????????????????????",
            "?????????????????????????????????????????????????????????????????????????????????",
            "???????????????",
            "??????????????????",
            "?????????????????????",
            "?????????",
            "?????????",
            "????????????????????????",
            "???????????????????????????",
            "??????????????????????????????????????????????????????",
            "????????????????????????",
            "?????????????????????????????????",
            "?????????????????????",
            "???????????????",
            "?????????????????????????????????",
            "????????????????????????",
            "???????????????",
            "??????????????????????????????????????????",
            "????????????????????????????????????????????????",
            "???????????????",
            "????????????????????????",
            "????????????????????????",
            "???????????????",
            "??????n.???????????????"
    };

    private String[] booken3 = {"cube",
            "submerge",
            "credit",
            "surrounding",
            "stove",
            "submit",
            "carrier",
            "imply",
            "strain",
            "consist",
            "strap",
            "efficient",
            "accommodation",
            "strategic",
            "layer",
            "exclaim",
            "representative",
            "forecast",
            "discipline",
            "neutral",
            "interpret",
            "knot",
            "desirable",
            "promote",
            "acceptance",
            "mayor",
            "equation",
            "routine",
            "ripe",
            "prove",
            "likewise",
            "chap",
            "explore",
            "overnight",
            "strategy",
            "straw",
            "bind",
            "stream",
            "bearing",
            "suppose",
            "access",
            "remain",
            "abstract",
            "stretch",
            "approximate",
            "striking",
            "abuse",
            "critic",
            "interpretation",
            "string",
            "illustrate",
            "helpful",
            "leak",
            "accountant",
            "crude",
            "product",
            "strip",
            "stripe",
            "communicate",
            "following",
            "hedge",
            "consumer",
            "emotional",
            "craft",
            "institute",
            "indispensable",
            "scheme",
            "scale",
            "replace",
            "bark"};

    private String[] bookcn3 ={"??????????????????",
            "?????????????????????",
            "???????????????????????????????????????????????????",
            "????????????????????????",
            "?????????????????????",
            "????????????????????????????????????????????????????????????",
            "???????????????????????????????????????????????????????????????",
            "???????????????",
            "????????????????????????????????????????????????????????????????????????????????????????????????????????????",
            "??????????????????????????????",
            "??????",
            "???????????????????????????",
            "???????????????",
            "??????????????????????????????????????????????????????",
            "????????????",
            "???????????????",
            "??????????????????",
            "???????????????",
            "?????????????????????????????????",
            "?????????????????????",
            "????????????????????????",
            "????????????????????????????????????",
            "???????????????????????????",
            "???????????????????????????????????????????????????",
            "????????????????????????",
            "??????",
            "??????????????????",
            "???????????????????????????????????????",
            "????????????????????????",
            "???????????????????????????",
            "?????????????????????",
            "???????????????????????????",
            "???????????????????????????????????????",
            "??????????????????????????????????????????",
            "???????????????",
            "??????????????????????????????",
            "?????????????????????????????????????????????????????????",
            "??????????????????????????????",
            "?????????????????????????????????????????????",
            "?????????????????????",
            "????????????????????????",
            "????????????????????????????????????",
            "????????????????????????",
            "???????????????????????????????????????????????????????????????",
            "?????????",
            "?????????????????????????????????????????????????????????",
            "??????????????????????????????????????????",
            "???????????????????????????",
            "???????????????",
            "??????????????????????????????",
            "??????",
            "???????????????????????????",
            "????????????",
            "????????????????????????",
            "?????????????????????????????????????????????",
            "????????????????????????",
            "??????????????????????????????",
            "??????",
            "?????????????????????????????????????????????????????????????????????",
            "?????????????????????",
            "???????????????????????????",
            "??????????????????????????????",
            "?????????????????????",
            "?????????????????????????????????",
            "??????????????????",
            "???????????????????????????",
            "????????????????????????",
            "?????????????????????????????????",
            "??????????????????????????????????????????????????????",
            "?????????"};

//    private String[] cet_4_en= {"cube",
//            "submerge",
//            "credit",
//            "surrounding",
//            "stove",
//            "submit",
//            "carrier",
//            "imply",
//            "strain",
//            "consist",
//            "strap",
//            "efficient",
//            "accommodation",
//            "strategic",
//            "layer",
//            "exclaim",
//            "representative",
//            "forecast",
//            "discipline",
//            "neutral",
//            "interpret",
//            "knot",
//            "desirable",
//            "promote",
//            "acceptance",
//            "mayor",
//            "equation",
//            "routine",
//            "ripe",
//            "prove",
//            "likewise",
//            "chap",
//            "explore",
//            "overnight",
//            "strategy",
//            "straw",
//            "bind",
//            "stream",
//            "bearing",
//            "suppose",
//            "access",
//            "remain",
//            "abstract",
//            "stretch",
//            "approximate",
//            "striking",
//            "abuse",
//            "critic",
//            "interpretation",
//            "string",
//            "illustrate",
//            "helpful",
//            "leak",
//            "accountant",
//            "crude",
//            "product",
//            "strip",
//            "stripe",
//            "communicate",
//            "following",
//            "hedge",
//            "consumer",
//            "emotional",
//            "craft",
//            "institute",
//            "indispensable",
//            "scheme",
//            "scale",
//            "replace",
//            "bark"};
//
//    private String[] cet_4_cn={"??????????????????",
//            "?????????????????????",
//            "???????????????????????????????????????????????????",
//            "????????????????????????",
//            "?????????????????????",
//            "????????????????????????????????????????????????????????????",
//            "???????????????????????????????????????????????????????????????",
//            "???????????????",
//            "????????????????????????????????????????????????????????????????????????????????????????????????????????????",
//            "??????????????????????????????",
//            "??????",
//            "???????????????????????????",
//            "???????????????",
//            "??????????????????????????????????????????????????????",
//            "????????????",
//            "???????????????",
//            "??????????????????",
//            "???????????????",
//            "?????????????????????????????????",
//            "?????????????????????",
//            "????????????????????????",
//            "????????????????????????????????????",
//            "???????????????????????????",
//            "???????????????????????????????????????????????????",
//            "????????????????????????",
//            "??????",
//            "??????????????????",
//            "???????????????????????????????????????",
//            "????????????????????????",
//            "???????????????????????????",
//            "?????????????????????",
//            "???????????????????????????",
//            "???????????????????????????????????????",
//            "??????????????????????????????????????????",
//            "???????????????",
//            "??????????????????????????????",
//            "?????????????????????????????????????????????????????????",
//            "??????????????????????????????",
//            "?????????????????????????????????????????????",
//            "?????????????????????",
//            "????????????????????????",
//            "????????????????????????????????????",
//            "????????????????????????",
//            "???????????????????????????????????????????????????????????????",
//            "?????????",
//            "?????????????????????????????????????????????????????????",
//            "??????????????????????????????????????????",
//            "???????????????????????????",
//            "???????????????",
//            "??????????????????????????????",
//            "??????",
//            "???????????????????????????",
//            "????????????",
//            "????????????????????????",
//            "?????????????????????????????????????????????",
//            "????????????????????????",
//            "??????????????????????????????",
//            "??????",
//            "?????????????????????????????????????????????????????????????????????",
//            "?????????????????????",
//            "???????????????????????????",
//            "??????????????????????????????",
//            "?????????????????????",
//            "?????????????????????????????????",
//            "??????????????????",
//            "???????????????????????????",
//            "????????????????????????",
//            "?????????????????????????????????",
//            "??????????????????????????????????????????????????????",
//            "?????????"};

    @Override
    public void onInit(int status) {

    }
}