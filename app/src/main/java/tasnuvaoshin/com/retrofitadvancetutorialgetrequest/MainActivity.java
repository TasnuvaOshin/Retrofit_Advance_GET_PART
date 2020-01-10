package tasnuvaoshin.com.retrofitadvancetutorialgetrequest;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tasnuvaoshin.com.retrofitadvancetutorialgetrequest.Tutorial3.ArrayDesignClass;
import tasnuvaoshin.com.retrofitadvancetutorialgetrequest.Tutorial3.ObjectDesignClass;
import tasnuvaoshin.com.retrofitadvancetutorialgetrequest.Tutorial3.PositionClass;
import tasnuvaoshin.com.retrofitadvancetutorialgetrequest.Tutorial3.TeamClass;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    OurRetrofitClient ourRetrofitClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit
                            .Builder()
                            .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                            .addConverterFactory(GsonConverterFactory.create())
                              .build();


        ourRetrofitClient = retrofit.create(OurRetrofitClient.class);


   Call<TeamClass> call = ourRetrofitClient.getData(10,"0pxcdEQdsGZ7DGBUQNstGwcNmdA0pPuZ9vTimkIP1zbwefRZGiS9MtFMZbW9");

   call.enqueue(new Callback<TeamClass>() {
       @Override
       public void onResponse(Call<TeamClass> call, Response<TeamClass> response) {
        final int cid=   response.body().getCountry_id();
        String cname = response.body().getName();


           Call<ArrayDesignClass> playercall = ourRetrofitClient.getPlayerData("0pxcdEQdsGZ7DGBUQNstGwcNmdA0pPuZ9vTimkIP1zbwefRZGiS9MtFMZbW9",cid);


           playercall.enqueue(new Callback<ArrayDesignClass>() {
               @Override
               public void onResponse(Call<ArrayDesignClass> call, Response<ArrayDesignClass> response) {
                         List<ObjectDesignClass> list =         response.body().getData();
                         for(ObjectDesignClass obj : list){

                           String dob =  obj.getDateofbirth();
                           String  fullname =obj.getFullname();
                           String gender = obj.getGender();


                             PositionClass positionClass = obj.getPositionClass();

                             String posname = positionClass.getName();

                             Log.d("cid", String.valueOf(cid));
                             Log.d("dob", String.valueOf(dob));
                             Log.d("fullname", String.valueOf(fullname));
                             Log.d("gender", String.valueOf(gender));
                             Log.d("posname", String.valueOf(posname));
//
                         }

               }

               @Override
               public void onFailure(Call<ArrayDesignClass> call, Throwable t) {

               }
           });

       }

       @Override
       public void onFailure(Call<TeamClass> call, Throwable t) {

       }
   });

//call.enqueue(new Callback<tutorial2Class>() {
//    @Override
//    public void onResponse(Call<tutorial2Class> call, Response<tutorial2Class> response) {
//        if(response.isSuccessful()) {
//
//              ObjectDataClass objectDataClass =  response.body().getData();
//
//              Log.d("name",objectDataClass.getName());
//              Log.d("id", String.valueOf(objectDataClass.getId()));
//              Log.d("resource",objectDataClass.getResource());
//              Log.d("updated_at",objectDataClass.getUpdated_at());
//
//        }
//        else {
//
//            Log.d("response","fail");
//        }
//
//    }
//
//    @Override
//    public void onFailure(Call<tutorial2Class> call, Throwable t) {
//     Log.d("response","fail");
//    }
//});





// call.enqueue(new Callback<OurMainDataClass>() {
//     @Override
//     public void onResponse(Call<OurMainDataClass> call, Response<OurMainDataClass> response) {
//         if(response.isSuccessful()){
//
//
//          List<ObjectDataClass> list = response.body().getData();
//
//          for(ObjectDataClass objectDataClass : list){
//
//              Log.d("id", String.valueOf(objectDataClass.getId()));
//              Log.d("name", String.valueOf(objectDataClass.getName()));
//              Log.d("resource", String.valueOf(objectDataClass.getResource()));
//              Log.d("updated_at", String.valueOf(objectDataClass.getUpdated_at()));
//          }
//
//
//
//
//         }else {
//             Log.d("response","fail");
//         }
//     }
//
//     @Override
//     public void onFailure(Call<OurMainDataClass> call, Throwable t) {
//         Log.d("response","fail");
//     }
// });



    }
}
