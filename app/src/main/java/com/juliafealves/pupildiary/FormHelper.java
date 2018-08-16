package com.juliafealves.pupildiary;

import android.widget.EditText;
import android.widget.RatingBar;

import com.juliafealves.pupildiary.model.Student;

public class FormHelper {

    private final EditText name;
    private final EditText address;
    private final EditText phone;
    private final EditText website;
    private final RatingBar rate;
    private Student student;

    public FormHelper(FormActivity activity) {
        this.name = activity.findViewById(R.id.form_name);
        this.address = activity.findViewById(R.id.form_address);
        this.phone = activity.findViewById(R.id.form_phone);
        this.website = activity.findViewById(R.id.form_website);
        this.rate = activity.findViewById(R.id.form_rate);
        this.student = new Student();
    }

    /**
     * Return a student with all datas of form.
     * @return Student
     */
    public Student getStudent(){
        student.setName(this.name.getText().toString());
        student.setAddress(this.address.getText().toString());
        student.setPhone(this.phone.getText().toString());
        student.setWebsite(this.website.getText().toString());
        student.setRate((double) this.rate.getProgress());

        return student;
    }

    /**
     * Fill the form with student`s data.
     * @param student Object Student
     */
    public void fill(Student student) {
        this.name.setText(student.getName());
        this.address.setText(student.getAddress());
        this.phone.setText(student.getPhone());
        this.website.setText(student.getWebsite());
        this.rate.setRating(student.getRate().intValue());
        this.student = student;
    }
}
