package com.app.unit.unitsa.ui.dialogs.datetimedialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public interface Listener {
        void onDateChosen(int year, int month, int day);

        long getCurrentTime();
    }

    private final Listener DUMMY_LISTENER = new Listener() {
        @Override
        public void onDateChosen(int year, int month, int day) {}

        @Override
        public long getCurrentTime() {
            return 0;
        }
    };

    private long maxDate;
    private long minDate;
    private Listener mListener = DUMMY_LISTENER;

    public DatePickerFragment(long maxDate, long minDate) {
        this.maxDate = maxDate;
        this.minDate = minDate;
    }

    public void setMaxDate(long maxDate) {
        this.maxDate = maxDate;
    }

    public void setMinDate(long minDate) {
        this.minDate = minDate;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mListener.getCurrentTime());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        DatePickerDialog datePickerDialog =
                new DatePickerDialog(getActivity(), this, year, month, day);
        if (maxDate != -1) {
            datePickerDialog.getDatePicker().setMaxDate(maxDate);
        }

        if (minDate != -1) {
            datePickerDialog.getDatePicker().setMinDate(minDate);
        }
        return datePickerDialog;
    }

    public void setListener(Listener listener) {
        mListener = (listener == null) ? DUMMY_LISTENER : listener;
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        mListener.onDateChosen(year, month, day);
    }
}
