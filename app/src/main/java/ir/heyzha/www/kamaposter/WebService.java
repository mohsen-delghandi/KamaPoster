package ir.heyzha.www.kamaposter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebService {

//    @POST("units/get")
//    Call<UnitModel> getUnits();
//
//    @POST("slider/get")
//    Call<List<SliderModel>> getSliderImages();
//
//    @POST("cities/get")
//    Call<CityAndProvinceModel> getCityAndProvince();
//
//    @POST("products/{id}")
//    Call<ProductModel> getProductsById(@Path("id") String unitId);
//
//    @POST("products/mostviewed/get")
//    Call<ProductModel> getMostViewedProducts();
//
//    @POST("products/recommended/get")
//    Call<ProductModel> getOfferedProducts();
//
//    @POST("register/{mobile}")
//    Call<UserModel> mobileRegister(@Path("mobile") String mobile);
//
//    @POST("register/detail/{mobile}/{name}/{family}/1/{reagentCode}")
//    Call<Object> finalRegister(@Path("mobile") String mobile, @Path("name") String name, @Path("family") String family, @Path("reagentCode") String reagentCode);
//
//    @POST("favorite/add/{mobile}/{id}")
//    Call<Boolean> addFavorite(@Path("mobile") String mobile, @Path("id") String id);
//
//    @POST("favorite/delete/{mobile}/{id}")
//    Call<Boolean> deleteFavorite(@Path("mobile") String mobile, @Path("id") String id);
//
//    @POST("favorite/get/{mobile}")
//    Call<List<FavoritesModel>> getFavorites(@Path("mobile") String mobile);
//
//    @POST("union/categories/get")
//    Call<List<UnionsModel>> getUnions();
//
//    @POST("union/categories/popular/get")
//    Call<List<UnionsModel>> getPopularUnions();
//
//    @POST("products/add/view/{id}")
//    Call<Boolean> countView(@Path("id") String id);

    @GET("default/app")
    Call<VersionModel> checkVersion(@Query("v") String versionCode);

}
