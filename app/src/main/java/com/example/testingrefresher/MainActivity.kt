package com.example.testingrefresher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.testingrefresher.databinding.ActivityMainBinding

/**
 *  Testing COverage
 *
 *  Unit Test Coverage          : 70%
 *  Integration Test Coverage   : 20%
 *  UI Tests Coverage           : 10%
 *
 * Types of Tests:
 *  1) Local Test        -> use 'com(test)' set
 *  2) Instrumented Test -> use 'com(androidTest)' set as it need android device/emulator and uses Android Framework/Libraries
 *
 * Dependencies :
 * implementation               -> Available for Local Tests i.e. 'com(test)' set and Instrumented Tests i.e.'com(androidTest)' set
 * testImplementation           -> Available for Local Tests only i.e. 'com(test)'
 * androidTestImplementation    -> Available for Instrumented Tests only i.e. 'com(androidTest)' set
 *
 * Note : At the time of build only 'implementation' dependencies are included in apk.
 *
 * Test Case Format:  SubjectUnderTest_actionOrInput_resultState
 *
 * Test Doubles :
 *               - Fakes : It's a light weight implementation class of the interface,
 *                         usually we hand code fake classes.
 *                         e.g. Roboelectric testing framework for roomtest -> MovieViewModel
 *               - Stubs : It's an object that provides predefined answers/return value to method calls.
 *               - Mocks : Is is similar to stub, but they allows tester to set answers to method calls when writing the test cases.
 *                         e.g. Mockito testing framework for CalculationsViewModel class
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CalculationsViewModel
    lateinit var factory: CalculationsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        factory = CalculationsViewModelFactory(MyCalculations())
        viewModel = ViewModelProvider(this, factory)
            .get(CalculationsViewModel::class.java)
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this
    }
}