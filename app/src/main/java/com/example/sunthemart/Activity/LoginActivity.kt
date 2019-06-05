package com.example.sunthemart.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.sunthemart.R
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import java.util.*

class LoginActivity() : AppCompatActivity(), View.OnClickListener {
    lateinit var mEtLg_Username:EditText
    lateinit var mEtLg_Password: EditText
    lateinit var callbackManager:CallbackManager
    lateinit var mFb_login_button:LoginButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)





        mInitWedgets();
        mInitObjects();
    }

    private fun mInitObjects() {
    }


    private fun mInitWedgets() {
        mEtLg_Username=findViewById(R.id.xEtLg_UserName)
        mEtLg_Password=findViewById(R.id.xEtLg_Password)


        val mTvCreate_Account=findViewById<TextView>(R.id.xTvCreate_Account);
        mTvCreate_Account.setOnClickListener(this);

        val mTvLg_Login=findViewById<TextView>(R.id.xTvLg_Login);
        mTvLg_Login.setOnClickListener(this);

        val mIvGoogle_Login=findViewById<ImageView>(R.id.xIvGoogle_Login);
        mIvGoogle_Login.setOnClickListener(this);
        val mFb_login_button=findViewById<LoginButton>(R.id.xFb_login_button);
        xFb_login_button.setOnClickListener(this)
        val mIvFb_Login=findViewById<ImageView>(R.id.xIvFb_Login);
        mIvFb_Login.setOnClickListener(this);
        mFb_login_button.setOnClickListener {  }




    }

    override fun onClick( v: View) {
        when(v.id) {
            R.id.xTvCreate_Account -> {
                val intent=Intent(this,RegisterActivity::class.java)
                startActivity(intent)
            }
            R.id.xTvLg_Login -> {
                val intent=Intent(this, MainActivity::class.java)
                startActivity(intent)

            }
            R.id.xFb_login_button ->{
                mGotoFaceBook()
            }
        }
    }

    private fun mGotoFaceBook() {
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "public_profile"))
        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                intent= Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                GraphRequest.newMeRequest(loginResult.accessToken, GraphRequest.GraphJSONObjectCallback {
                        obj: JSONObject, response: GraphResponse ->
                    var email:String=obj.getString("email")
                    var first_name:String=obj.getString("first_name")
                    var id:String=obj.getString("id")
                    var url:String=obj.getString("https://graph.facebook.com/\" + id + \"/picture?type=normal\"")

                println("successful" + loginResult.accessToken)

            })
            }

            override fun onCancel() {

            }

            override fun onError(error: FacebookException) {

            }
        });
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }




    private fun mCheckValidation():Boolean{
        var mCheckValidate :Boolean=false
        if(mEtLg_Username.text.toString().trim().isEmpty()||mEtLg_Password.text.toString().trim().isEmpty()){
            mCheckValidate=true
        }
        else
            mCheckValidate=false

        return mCheckValidate

    }


}
