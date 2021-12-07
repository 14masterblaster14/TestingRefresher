package com.example.testingrefresher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.testingrefresher.databinding.ActivityMainBinding

/**
 *  Testing Coverage
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
 *                         Its functional substitution for the real unit.
 *                         e.g. Roboelectric testing framework for roomtest -> MovieViewModel
 *               - Stubs : It's an object that provides predefined answers/return value to method calls.
 *               - Mocks : Is is similar to stub, but they allows tester to set answers to method calls when writing the test cases.
 *                         e.g. Mockito testing framework for CalculationsViewModel class
 *
 *  Mockito : Easily creates stubs and mocks
 *
 * Note :-
 *          -   Treat all arguments and return values as non-nullable unless annotated with @Nullable
 *          -   Don't use Singleton if you want to test it, as it will fail other cases in same class due to singleton constraints
 *              as all cases will be executed simultaneously by creating different instances.
 *          -   Avoid static functional calls as static methods are hidden dependencies that can't be substituted with test doubles
 *
 *
 *          Object                              Vs              Data Structure
 *          ======                              ==              ==============
 *      -   Expose Behaviour                                  - Expose Data and should nnot have Behaviour
 *      -   Hide internal implementation details              - Can be instantiated by other objects and Data structures
 *      -   should be injected into another object            - Unit test for objects tests data structures implicitly
 *      -   Need to be unit tested explicitly                 - No need to substitute with test doubles
 *      -   Eligible to be substituted with test doubles
 *
 *
 *   AAA Test Strategy :  Arrange -> Act -> Assert
 *
 *
 *
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