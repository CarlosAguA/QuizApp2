package carlosdeveloper.com.quizapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0 ;
    /*Question 1 variables */
    boolean solarOne, geothermalOne, bioGasOne, oilOne ;
    CheckBox cb_solarOne, cb_geoth_One, cb_biogasOne, cb_oilOne ;
    /*Question 2 variables */
    boolean gasTwo, windTwo, hydraulicTwo, coalTwo;
    CheckBox cb_gasTwo, cb_windTwo, cb_coalTwo ,cb_hydraulicTwo ;
    /*Question 3, 4 ,5 variables */
    String turbine ="" , panel="" , atomic="" , empty="" ;
    TextView questionFive, questionFour , questionThree;
    /*Question 6 variables */
    RadioGroup rbMostUsedEnergy ; // Radio Group that contains options for question 6
    int rb_controller = 0 ;
    /*Question 7 variables */
    boolean plugSeven , truckSeven , lightSeven, readSeven ;
    CheckBox cb_plug , cb_truck, cb_light , cb_read ;
    /*Submit Button*/
    Button submit ;
    String summary = "Wrong answers:\n ";

     String track = "hola" ;

    int selector = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb_solarOne = (CheckBox) findViewById(R.id.cb_one_solar);
        cb_biogasOne = (CheckBox) findViewById(R.id.cb_one_biogas);
        cb_geoth_One = (CheckBox) findViewById(R.id.cb_one_geoth);
        cb_oilOne = (CheckBox) findViewById(R.id.cb_one_oil);

        cb_gasTwo = (CheckBox) findViewById(R.id.cb_two_gas);
        cb_windTwo = (CheckBox) findViewById(R.id.cb_two_wind);
        cb_hydraulicTwo = (CheckBox) findViewById(R.id.cb_two_hyd);
        cb_coalTwo = (CheckBox) findViewById(R.id.cb_two_coal);

        cb_plug = (CheckBox) findViewById(R.id.cb_seven_plug);
        cb_truck = (CheckBox) findViewById(R.id.cb_seven_truck);
        cb_light = (CheckBox) findViewById(R.id.cb_seven_lights);
        cb_read = (CheckBox) findViewById(R.id.cb_seven_read);

        questionFive = (TextView) findViewById(R.id.atomic_input);
        questionFour = (TextView) findViewById(R.id.panel_input);
        questionThree = (TextView) findViewById(R.id.turbine_input);

        rbMostUsedEnergy = (RadioGroup) findViewById(R.id.rg_question_six);
        submit = (Button) findViewById(R.id.submit_button);

        /*
           onClick Listener for the Submit Button
         */
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                submitMessage();
            }
        });

        /*
           onCheckedChange Listener for the Radio Group of question 6
         */
        rbMostUsedEnergy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId) {
                    case R.id.button1:

                        if(selector == 0){
                            summary = summary + "6\n";
                        }
                        if (selector == 3){
                            score = score - 1 ;
                        }

                        selector = 1;
                        break;
                    case R.id.button2:

                        if(selector == 0) {
                            summary = summary + "6\n";
                        }
                        if (selector == 3){
                            score = score - 1 ;
                        }

                        selector = 2;
                        break;
                    case R.id.button3:
                        if (selector == 0 || selector == 1 || selector == 2) {
                            score = score + 1;
                           // track.replace("o","e");
                           // Log.d("RESULTADO", track);
                            //Why replace is ignored?
                            summary.replace("6\n", "");
                        }
                        selector = 3;
                        break;
                }
            }

        });

    }

    private void submitMessage() {

        gradeQuestionOne();
        gradeQuestionTwo();
        gradeQuestionThree();
        gradeQuestionFour();
        gradeQuestionFive();
        gradeQuestionSeven();

        Toast.makeText(getApplicationContext(),"Quiz Completed!\n"  + "Score: " + score + "/7\n"
                        + summary,
                Toast.LENGTH_LONG).show();

        submit.setEnabled(false);

    }

    /*
      Method: Grading logic using boolean variables and if Statement for checkBoxex
     */
    public void gradeQuestionSeven() {
      /*boolean plugSeven , truckSeven , lightSeven, readSeven ; */
        plugSeven = cb_plug.isChecked();
        truckSeven = cb_truck.isChecked();
        lightSeven = cb_light.isChecked();
        readSeven = cb_read.isChecked();

        if (readSeven && lightSeven && plugSeven) {
            score = score + 1;
        }else{
            summary = summary + "7\n";
        }

    }

    /*
     Method: Grading logic using String variables and if Statement for comparing possible answers
    */
    public void gradeQuestionFive() {
        atomic = questionFive.getText().toString().toLowerCase().trim();
        Log.d("QUESTION FOUR", atomic) ;

        if(atomic.equals("atomic") || atomic.equals("atomic energy") || atomic.equals("nuclear energy")
                || atomic.equals("nuclear")) {
            score = score + 1;
        }else{
            summary = summary + "5\n";
        }

    }

    /*
     Method: Grading logic using String variables and if Statement for comparing possible answers
    */
    public void gradeQuestionFour() {
        panel = questionFour.getText().toString().toLowerCase().trim();
        Log.d("QUESTION FOUR", panel) ;

        if(panel.equals("panel") || panel.equals("solar panel") || panel.equals("solar cell")) {
            score = score + 1;
        }else{
            summary = summary + "4\n";
        }
    }

    /*
     Method: Grading logic using String variables and if Statement for comparing possible answers
    */
    public void gradeQuestionThree(){
        turbine = questionThree.getText().toString().toLowerCase().trim();
        Log.d("QUESTION THRRE", turbine) ;

        if(turbine.equals("turbine") || turbine.equals("wind turbine")) {
            score = score + 1;
        }else{
            summary = summary + "3\n";
        }
    }

    /*
      Method: Grading logic using boolean variables and if Statement for checkBoxes
     */
    public void gradeQuestionTwo() {
        /*boolean gasTwo, windTwo, hydraulicTwo, coalTwo; */
        gasTwo = cb_gasTwo.isChecked();
        windTwo = cb_windTwo.isChecked();
        hydraulicTwo = cb_hydraulicTwo.isChecked();
        coalTwo = cb_coalTwo.isChecked();

        if (coalTwo && gasTwo) {
            score = score + 1;
        }else{
            summary = summary + "2\n";
        }
    }

    /*
      Method: Grading logic using boolean variables and if Statement for checkBoxes
     */
    public void gradeQuestionOne(){
        solarOne = cb_solarOne.isChecked();
        bioGasOne = cb_biogasOne.isChecked();
        geothermalOne = cb_geoth_One.isChecked();
        oilOne = cb_oilOne.isChecked();

        if(solarOne && geothermalOne & bioGasOne)
        {
            score = score + 1;
        }else{
            summary = summary + "1\n";
        }
    }

    public void resetQuiz (View view){
        score = 0;
        submit.setEnabled(true);
        questionFive.setText(empty);
        questionFour.setText(empty);
        questionThree.setText(empty);
        resetCheckBoxes();
        selector = 0 ;
    }

    /*Reset CheckButton and RadioButton elements of question 1,2,7 */
    private void resetCheckBoxes() {

        cb_plug.setChecked(false);
        cb_truck.setChecked(false);
        cb_light.setChecked(false);
        cb_read.setChecked(false);

        cb_solarOne.setChecked(false);
        cb_geoth_One.setChecked(false);
        cb_biogasOne.setChecked(false);
        cb_oilOne.setChecked(false);

        cb_hydraulicTwo.setChecked(false);
        cb_windTwo.setChecked(false);
        cb_coalTwo.setChecked(false);
        cb_gasTwo.setChecked(false);

        rbMostUsedEnergy.clearCheck();

        summary = "Wrong answers:\n ";
    }

}

