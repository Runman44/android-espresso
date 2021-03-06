/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.espresso.basicSample

import android.app.Activity
import android.os.Bundle
import com.example.android.testing.espresso.basicSample.test1.Test1Activity
import com.example.android.testing.espresso.basicSample.test2.Test2Activity
import com.example.android.testing.espresso.basicSample.test3.Test3Activity
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent

/**
 * An [Activity] that gets a text string from the user and displays it back when the user
 * clicks on one of the two buttons. The first one shows it in the same activity and the second
 * one opens another activity and displays the message.
 */
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonChangeText.setOnClickListener {
            textToBeChanged.text =  editTextUserInput.text.toString()
        }

        buttonNewActivity.setOnClickListener {
            startActivity(ShowTextActivity.newStartIntent(this, editTextUserInput.text.toString()))
        }

        test1.setOnClickListener {
            startActivity(Test1Activity.newStartIntent(this, editTextUserInput.text.toString()))
        }

        test2.setOnClickListener {
            startActivity(Test2Activity.newStartIntent(this, editTextUserInput.text.toString()))
        }

        test3.setOnClickListener {
            startActivity(Test3Activity.newStartIntent(this, editTextUserInput.text.toString()))
        }

        test4.setOnClickListener {
            val photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            startActivityForResult(photoPickerIntent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            textToBeChanged.text = data?.data.toString()
        }
    }
}
