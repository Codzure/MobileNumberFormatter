package com.leonard.mobilenumberformatter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.pedant.SweetAlert.SweetAlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFormat.setOnClickListener {
            var PhoneNo = etPhoneNumber.text
            var country = country.selectedItem.toString()

            if (!PhoneNo.isNullOrEmpty()) {
                if (PhoneNumberFormatter.isValidPhoneNumber(PhoneNo.toString(),country))
                    etResult.setText(PhoneNumberFormatter.formatPhoneNumber(PhoneNo.toString(), country))
                else{
                    SweetAlertDialog(this@MainActivity, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Oops...")
                            .setContentText("Wrong Number Format. Make sure your phone number format is correct  and try again")
                            .show()
                }
            }

            else{
                SweetAlertDialog(this@MainActivity, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Please enter Phone Number!")
                        .show()
            }
        }


    }
}
