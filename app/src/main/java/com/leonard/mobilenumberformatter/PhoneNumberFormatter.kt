package com.leonard.mobilenumberformatter

import java.util.regex.Pattern

/**
 * Function to validate phone number
 */

object PhoneNumberFormatter {


    /**
     * Function to validate phone number
     * @param phoneNumber - phone number to validate
     * @return is valid
     */
    fun isValidPhoneNumber(phoneNumber: String?, country: String?): Boolean {
        val number = phoneNumber?.replace(" ".toRegex(), "")

        if (phoneNumber != null && phoneNumber != "" && number != "") {
            if (country.equals("Kenya")) {
                val pattern = Pattern.compile("^(?:254|\\+254|0)?(7[0-9]{8})$")
                return pattern.matcher(number).matches()
            }

            if (country.equals("Uganda")) {
                val pattern = Pattern.compile("^(?:256|\\+256|0)?(7[0-9]{8})$")
                return pattern.matcher(number).matches()
            }

            if (country.equals("Tanzania")) {
                val pattern = Pattern.compile("^(?:255|\\+255|0)?(7[0-9]{8})$")
                return pattern.matcher(number).matches()
            }
        }

        return false
    }

    fun formatPhoneNumber(phoneNumber: String, country: String?): String {
        val phone = cleanPhoneNumber(phoneNumber)


        if (country.equals("Uganda")) {
            return phone.replaceFirst("0".toRegex(), "256")
        }

        return if (country.equals("Tanzania")) {
            phone.replaceFirst("0".toRegex(), "255")
        } else
            phone.replaceFirst("0".toRegex(), "254")
    }

    private fun cleanPhoneNumber(phoneNumber: String): String {
        val formattedNumber: String = when {
            phoneNumber.startsWith("+254" ) -> phoneNumber.replace("+254", "0")
            phoneNumber.startsWith("254") -> phoneNumber.replace("254", "0")
            phoneNumber.startsWith("255") -> phoneNumber.replace("255", "0")
            phoneNumber.startsWith("+255") -> phoneNumber.replace("+255", "0")
            phoneNumber.startsWith("256") -> phoneNumber.replace("256", "0")
            phoneNumber.startsWith("+256") -> phoneNumber.replace("+256", "0")
            phoneNumber.startsWith("7") -> "0$phoneNumber"
            else -> phoneNumber
        }

        return formattedNumber.replace(" ", "")
    }

}
