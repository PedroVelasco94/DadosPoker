package com.pedrovelasco.dadospoker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView lblDado1 = (TextView) findViewById(R.id.lblDado1);
        final TextView lblDado2 = (TextView) findViewById(R.id.lblDado2);
        final TextView lblDado3 = (TextView) findViewById(R.id.lblDado3);
        final TextView lblDado4 = (TextView) findViewById(R.id.lblDado4);
        final TextView lblDado5 = (TextView) findViewById(R.id.lblDado5);
        final TextView Resul = (TextView) findViewById(R.id.Resul);
        final CheckBox cbDado1 = (CheckBox) findViewById(R.id.cbDado1);
        final CheckBox cbDado2 = (CheckBox) findViewById(R.id.cbDado2);
        final CheckBox cbDado3 = (CheckBox) findViewById(R.id.cbDado3);
        final CheckBox cbDado4 = (CheckBox) findViewById(R.id.cbDado4);
        final CheckBox cbDado5 = (CheckBox) findViewById(R.id.cbDado5);


        Button roll = (Button) findViewById(R.id.ROLL);





        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int c9 = 0;
                int c10 = 0;
                int cJ = 0;
                int cQ = 0;
                int cK = 0;
                int cAs = 0;

                if(!cbDado1.isChecked())
                lblDado1.setText(letraAleatoria());

                if(!cbDado2.isChecked())
                lblDado2.setText(letraAleatoria());

                if(!cbDado3.isChecked())
                lblDado3.setText(letraAleatoria());

                if(!cbDado4.isChecked())
                lblDado4.setText(letraAleatoria());

                if(!cbDado5.isChecked())
                lblDado5.setText(letraAleatoria());

                String[] numActual = new String[]{(String) lblDado1.getText(),(String) lblDado2.getText(),
                        (String) lblDado3.getText(), (String) lblDado4.getText(), (String) lblDado5.getText()};

                String[] caras = new String[]{"As", "K", "Q", "J", "10","9"};


                for(String nac : numActual){

                    for(String nlis : caras){

                        if(nac.equals(nlis)){
                            if(nlis.equals("9"))c9++;
                            if(nlis.equals("10"))c10++;
                            if(nlis.equals("J"))cJ++;
                            if(nlis.equals("Q"))cQ++;
                            if(nlis.equals("K"))cK++;
                            if(nlis.equals("As"))cAs++;
                        }
                    }
                }

                Integer[] rnum = new Integer[]{c9,c10,cJ,cQ,cK,cAs};

                for(String n : numActual){
                    for(String u : numActual){
                        if(!n.equals(u)){
                            Resul.setText("-");
                        }
                    }
                }



                if(numActual[0].equals("K") && numActual[1].equals("Q") && numActual[2].equals("J")
                  && numActual[3].equals("10") && numActual[4].equals("9") ||
                  numActual[0].equals("As") && numActual[1].equals("K") && numActual[2].equals("Q")
                  && numActual[3].equals("J") && numActual[4].equals("10")){
                    Resul.setText("Escalera");
                }else {

                    for (int i = 0; i < rnum.length; i++) {
                        for (int j = 0; j < rnum.length; j++) {

                            if (rnum[i].equals(3) && rnum[j].equals(2)) {
                                Resul.setText("Full");
                                break;
                            }



                            if (rnum[i].equals(2) && !rnum[j].equals(3)) {
                                Resul.setText("Pareja");
                            }




                            if (rnum[i].equals(2) && rnum[j].equals(2) && i != j) {
                                Resul.setText("Doble pareja");
                                break;
                            }


                            if (rnum[i].equals(3) && i != j) Resul.setText("Trio");

                            if (rnum[i].equals(4) && i != j) Resul.setText("Poker");


                            if (rnum[i].equals(5)) Resul.setText("RePoker");


                        }


                    }
                }




            }
        });





    }

    public String letraAleatoria(){

        String[] caras = new String[]{"As", "K", "Q", "J", "10","9"};
        return caras[numeroAleatorio()];

    }

    public int numeroAleatorio(){

        Random randomGenenerator = new Random();
        int randomNumber = randomGenenerator.nextInt(6);
        return randomNumber;

    }
}
