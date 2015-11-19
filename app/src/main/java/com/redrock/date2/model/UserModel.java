package com.redrock.date2.model;

import android.content.Context;

import com.jude.beam.model.AbsModel;
import com.jude.http.RequestManager;
import com.jude.http.RequestMap;
import com.jude.utils.JFileManager;
import com.jude.utils.JUtils;
import com.redrock.date2.app.TokenParams;
import com.redrock.date2.config.API;
import com.redrock.date2.config.Dir;
import com.redrock.date2.model.bean.Account;
import com.redrock.date2.model.bean.CareNum;
import com.redrock.date2.model.bean.Date;
import com.redrock.date2.model.bean.Letter;
import com.redrock.date2.model.bean.User;
import com.redrock.date2.model.callback.DataCallback;
import com.redrock.date2.model.callback.StatusCallback;

import java.util.HashMap;
import java.util.Random;

import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

/**
 * Created by zhuchenxi on 15/8/2.
 */
public class UserModel extends AbsModel {
    public static UserModel getInstance() {
        return getInstance(UserModel.class);
    }

    public static final String ACCOUNT_FILE = "account";
    private User account;
    private BehaviorSubject<User> mUserBehaviorSubject;
    private BehaviorSubject<Account> mAccountBehaviorSubject;

    @Override
    protected void onAppCreateOnBackThread(Context ctx) {
        super.onAppCreateOnBackThread(ctx);
        mUserBehaviorSubject = BehaviorSubject.create();
        mAccountBehaviorSubject = BehaviorSubject.create();
        if(getAccount()!=null){
            setHeader(getId(),getToken());
        }else {
            setHeader(0,"");
        }
    }

    public int getId() {
        if(getAccount()!=null)
        return getAccount().getId();
        else return 0;
    }

    public String getToken() {
        if(getAccount()!=null)
        return getAccount().getToken();
        else return "";
    }

    public void registerUserChange(Action1<User> action1) {
        mUserBehaviorSubject.subscribe(action1);
    }

    public void registerRegisterListener(Action1<Account> action1) {
        mAccountBehaviorSubject.subscribe(action1);
    }

    public User getAccount() {
        if (account != null) return account;
        else
            return (User) JFileManager.getInstance().getFolder(Dir.Object).readObjectFromFile(ACCOUNT_FILE);
    }

    public void setAccount(User user) {
        JUtils.Log("Login in");
        account = user;
        if (user != null)
            JFileManager.getInstance().getFolder(Dir.Object).writeObjectToFile(user, ACCOUNT_FILE);
        else
            JFileManager.getInstance().getFolder(Dir.Object).deleteChild(ACCOUNT_FILE);

        //一定要在最后
        mUserBehaviorSubject.onNext(user);
    }

    //设置token
    public void setHeader(int id,String token){
        HashMap<String,String> header=new HashMap<>();
        header.put("uid",id+"");
        header.put("token",token);
        RequestManager.getInstance().setHeader(header);
    }

    public void login(String number, String password, DataCallback<User> callback) {
        RequestMap params = new RequestMap();
        params.put("loginUser", number);
        params.put("password", password);
        RequestManager.getInstance().post(API.URL.Login, params, callback.add(new DataCallback<User>() {
            @Override
            public void success(String info, User data) {
                setAccount(data);
            }
        }));
    }

    public void register(String tel, String password, String code, int gender, String nickname, StatusCallback callback) {
        RequestMap params = new RequestMap();
        params.put("tel", tel);
        params.put("password", password);
        params.put("code", code);
        params.put("nickname", nickname);
        params.put("gender", gender + "");
        RequestManager.getInstance().post(API.URL.Register, params, callback.add(new StatusCallback() {
            @Override
            public void success(String info) {
                mAccountBehaviorSubject.onNext(new Account(tel, password));
            }
        }));
    }

    public void findPassword(String number, String code, String password, DataCallback<User> callback) {
        RequestMap params = new RequestMap();
        params.put("phone", number);
        params.put("code", code);
        params.put("password", password);
        RequestManager.getInstance().post(API.URL.Pwdfind, params, callback);
    }

    public void certification(String number, String school, String realName, String stuCard, DataCallback<User> callback) {
        RequestMap params = new TokenParams();
        params.put("phone", number);
        params.put("realName", realName);
        params.put("school", school);
        params.put("stuCard", stuCard);
        RequestManager.getInstance().post(API.URL.Pwdfind, params, callback);
    }


    public void LoginOut() {
        setAccount(null);
    }


    public void getUserDetail(int id, DataCallback<User> callback) {
        RequestMap params = new TokenParams();
        params.put("get_uid", id+"");
        RequestManager.getInstance().post(API.URL.getUserData, params, callback);
    }

    //获取收藏列表
    public void getMyCollectList(int page,DataCallback<Date[]> callback){
        RequestMap params = new TokenParams();
        params.put("page", page+"");
        RequestManager.getInstance().post(API.URL.getCollectList,params,callback);
    }

    //获取私信列表
    public void getMyLetterList(int page,DataCallback<Letter[]> callback){
        RequestMap params = new TokenParams();
        params.put("page", page+"");
        RequestManager.getInstance().post(API.URL.getLetterList,params,callback);
    }

    //获取发起的约的列表
    public void getDateRecordList(int page,DataCallback<Date[]> callback){
        RequestMap params = new TokenParams();
        params.put("page", page+"");
        RequestManager.getInstance().post(API.URL.getMyDateList,params,callback);
    }

    //获取参加的约的列表
    public void getJoinDateList(int page,DataCallback<Date[]> callback){
        RequestMap params = new TokenParams();
        params.put("page", page+"");
        RequestManager.getInstance().post(API.URL.getMyJoinedDateList,params,callback);
    }

    //获取关注数
    public void getAttendCount(int id,DataCallback<CareNum> callback){
        RequestMap params = new TokenParams();
        params.put("get_uid", id+"");
        RequestManager.getInstance().post(API.URL.getAttendCount,params,callback);
    }

    //获取我关注的人
    public void getAttendPersonList(int page,DataCallback<User[]> callback){
        RequestMap params = new TokenParams();
        params.put("page", page+"");
        RequestManager.getInstance().post(API.URL.getMyAttendPerson,params,callback);
    }

    //关注他人
    public void attendOther(int id,StatusCallback callback){
        RequestMap params = new TokenParams();
        params.put("add_uid", id+"");
        RequestManager.getInstance().post(API.URL.addCare,params,callback);
    }

    //取消关注
    public void cancleAttendOther(int id,StatusCallback callback){
        RequestMap params = new TokenParams();
        params.put("del_uid", id+"");
        RequestManager.getInstance().post(API.URL.delCare,params,callback);
    }

    //实名认证
    public void verifyName(String realName,String school,String stuCard,StatusCallback callback){
        RequestMap params = new TokenParams();
        params.put("realName", realName);
        params.put("school",school);
        params.put("stuCard",stuCard);
        RequestManager.getInstance().post(API.URL.Certification,params,callback);
    }

    //修改头像
    public void modifyFace(String faceUrl,StatusCallback callback){
        RequestMap params = new TokenParams();
        params.put("avatar", faceUrl);
        RequestManager.getInstance().post(API.URL.modifyFace,params,callback);
    }
    //修改签名
    public void modifySign(String sign,StatusCallback callback){
        RequestMap params = new TokenParams();
        params.put("signature", sign);
        RequestManager.getInstance().post(API.URL.modifySign,params,callback);
    }
    //修改爱好
    public void modifyHobby(int[] hobby,StatusCallback callback){
        StringBuffer s=new StringBuffer("[");
        for(int a:hobby){
            s=s.append(a).append(",");
        }
        s=s.delete(s.length()-1,s.length()-1).append("]");
        RequestMap params = new TokenParams();
        params.put("hobby",s.toString());
        RequestManager.getInstance().post(API.URL.modifyHobby,params,callback);
    }

    //修改密码
    public void modifyPassword(String oldPassword,String newPassword,StatusCallback callback){
        RequestMap params = new TokenParams();
        params.put("oldpassword", oldPassword);
        params.put("newpassword",newPassword);
        RequestManager.getInstance().post(API.URL.modifyPassword,params,callback);
    }

    //搜索用户
    public void searchUser(String content,DataCallback<User[]> callback){
        RequestMap params = new TokenParams();
        params.put("content", content);
        RequestManager.getInstance().post(API.URL.searchUser,params,callback);
    }
    //热搜用户
    public void searchHotUser(String content,DataCallback<User[]> callback){
        RequestManager.getInstance().post(API.URL.searchHotUser,null,callback);
    }


    public void getAttention(String id, DataCallback<User[]> callback) {
        //new Handler().postDelayed(() -> callback.success("",createVirtualUsers(20)), 1000);
    }


    public User createEmptyUser() {
        return null;
    }

    public User[] createVirtualUsers(int count) {
        User[] users = new User[count];
        for (int i = 0; i < users.length; i++) {
            users[i] = createVirtualUser();
        }
        return users;
    }

    //    public UserDetail createVirtualUserDetail(){
//        Random r= new Random();
//        return new UserDetail(
//                "1",
//                "http://i2.hdslb.com/user/1244/124416/myface.jpg",
//                "Jude",
//                "投资教父阎焱：不以盈利为目的的商业都是假的，伪的互联网企业和需求都是用钱砸出来的",
//                r.nextInt(2),2010+r.nextInt(6),true,
//                "128","56","宋伊雪",
//                "吃货 运动狂魔",
//                "山东蓝翔",
//                "12580");
//    }
//
    public User createVirtualUser() {
        Random r = new Random();
        return null;
    }

}
