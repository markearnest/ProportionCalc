package org.mystikos.proportioncalc;

import org.mystikos.proportioncalc.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProportionCalc extends Activity {
	private EditText num1;
	private EditText den1;
	private EditText num2;
	private EditText den2;
	private TextView error;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		num1 = (EditText) findViewById(R.id.EditText01);
		den1 = (EditText) findViewById(R.id.EditText02);
		num2 = (EditText) findViewById(R.id.EditText03);
		den2 = (EditText) findViewById(R.id.EditText04);
		error = (TextView) findViewById(R.id.TextView01);
	}

	// This method is called at button click because we assigned the name to the
	// "On Click property" of the button
	public void onClickHandler(View view) {
		num1 = (EditText) findViewById(R.id.EditText01);
		den1 = (EditText) findViewById(R.id.EditText02);
		num2 = (EditText) findViewById(R.id.EditText03);
		den2 = (EditText) findViewById(R.id.EditText04);
		error.setText("");
		if (num1.getText().length() == 0 
				&& num2.getText().length() != 0
				&& den1.getText().length() != 0
				&& den2.getText().length() != 0) {
			num1.setText(String.valueOf(calcProp(num2, den1, den2)));
		} else if (num2.getText().length() == 0
				&& num1.getText().length() != 0
				&& den1.getText().length() != 0
				&& den2.getText().length() != 0) {
			num2.setText(String.valueOf(calcProp(num1, den2, den1)));
		} else if (den1.getText().length() == 0
				&& num1.getText().length() != 0
				&& num2.getText().length() != 0
				&& den2.getText().length() != 0) {
			den1.setText(String.valueOf(calcProp(num1, den2, num2)));
		} else if (den2.getText().length() == 0
				&& num1.getText().length() != 0
				&& num2.getText().length() != 0
				&& den1.getText().length() != 0) {
			den2.setText(String.valueOf(calcProp(num2, den1, num1)));
		} else {
			error.setText("ERROR: You must leave one (and only one) field blank to be calculated");
		}
	}

	public void onClearHandler(View view) {
		error.setText("");
		num1.setText("");
		num2.setText("");
		den1.setText("");
		den2.setText("");
	}

	private float calcProp(EditText m1s, EditText m2s, EditText d1s) {
		float m1 = Float.parseFloat(m1s.getText().toString());
		float m2 = Float.parseFloat(m2s.getText().toString());
		float d1 = Float.parseFloat(d1s.getText().toString());
		return (m1 * m2) / d1;
	}

}