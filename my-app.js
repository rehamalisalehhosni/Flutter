// Initialize app
var myApp = new Framework7({
  // App id
  id: 'com.ilyatours.test',
  name: 'My App',
  fastClicks:false,
  pushState: true,
  swipePanel: 'left',
  animatePages:true,
  animateNavBackIcon:true,
  precompileTemplates: true, //
  template7Pages: true ,
  swipeBackPage:false,
  swipePanelCloseOpposite:false,
  swipePanelOnlyClose:false,
  pushState: true,
  swipeout:true,
  smartSelectPopupCloseTemplate: '',
  smartSelectBackOnSelect: true,
  cache: true, /* disable caching */
  domCache: true ,//enable inline pages
  cacheDuration:1000*60*10,
  ignoreCache:true,
  reloadPrevious:true,
  // Enable swipe panel
  panel: {
    swipe: 'left',
  },
  statusbar: {
    iosOverlaysWebview: true,
  },
});
var $$ = Dom7;
var trip_page_number=0;
var appData=[];
var UserData=null;
myApp.onPageInit('*', function (page) {
  if(window.localStorage.getItem("User")){
    UserData=JSON.parse( window.localStorage.getItem("User") );
    //drawMenu();
  }

  if($('.swiper-container').length){
    var mySwiper = myApp.swiper('.swiper-container', {
      pagination:'.swiper-pagination'
    });
  }
  if($('.calender').length){
    var    myCalendar = myApp.calendar({
      input: '.calender'
    });
    var    myCalendar = myApp.calendar({
      input: '.calender2'
    });
  }
})
myApp.onPageInit('list', function (page) {
  $(".rating>span").on("click", function(e) {
    // remove all active classes first, needed if user clicks multiple times
    $(this).closest('div').find('.active').removeClass('active');
    $(e.target).addClass('active').prevAll().addClass('active');  // the element user has clicked on
    var numStars = $(e.target).index();
  });
})

myApp.onPageBeforeAnimation('*',function(e){
  displayLanguage();
  myApp.closeModal('.picker-modal');


  //ln.init();
});

myApp.onPageAfterAnimation('*',function(e){
//  myApp.closePanel();
  //$$('.page-on-left').removeClass('hidden');
  //ln.init();
});

function onDeviceReady() {
  // Now safe to use the Cordova API
  //ln.init();
  console.log('device Ready');
  checkConnection();
  // document.addEventListener("backbutton", function(e){
  //   myApp.closePanel();
  //   // if(myCalendar){
  //   //   myCalendar.close();
  //   // }
  //   if ( mainView.activePage.name === 'index') {
  //     //window.location = "#exitDialog";
  //     exitAppPopup();
  //   }else{
  //     myApp.closeModal('.picker-modal');
  //     history.back();
  //   };
  // });
}
function exitAppPopup() {
  myApp.confirm('Do you really want to close this app?','Ilyatours',function () {
    navigator.app.exitApp();
  });
  //return false;
};

// Handle Cordova Device Ready Event
document.addEventListener('deviceready', onDeviceReady, false);

//$$(document).on('deviceready', onDeviceReady);
// Add view
var mainView = myApp.addView('.view-main', {
  // Because we want to use dynamic navbar, we need to enable it for this view:
  dynamicNavbar: true
});


var AppData=[];
function checkConnection() {
  var networkState = navigator.connection.type;
  var states = {};
  states[Connection.UNKNOWN]  = 'Unknown connection';
  states[Connection.ETHERNET] = 'Ethernet connection';
  states[Connection.WIFI]     = 'WiFi connection';
  states[Connection.CELL_2G]  = 'Cell 2G connection';
  states[Connection.CELL_3G]  = 'Cell 3G connection';
  states[Connection.CELL_4G]  = 'Cell 4G connection';
  states[Connection.CELL]     = 'Cell generic connection';
  states[Connection.NONE]     = 'No network connection';
  if(networkState==Connection.NONE){
    $$('.connection-msg').addClass('showMsg');
  }else{
    $$('.connection-msg').removeClass('showMsg');
  }
}
function changeLaguage(){

  var lang=window.localStorage.getItem("lang");
  releaseApp(lang);
}
var currentLang;

function displayLanguage()
{
  ln.init();
  //console.log(languageName);
  //ln.getLanguage();
//  ln.getLanguage( );

}

//Select Home  Page
function drawIndex(){
  myApp.params.swipePanel = false;
  var output='';
    output+= "<div class='select-lang '>";
    output+= "          <h1 class='text'>";
    output+=  "            <p>Choose Language</p>";
    output+=  "            <p >اختر لغتك</p>";
    output+= "          </h1>";
    output+= "  <a   href='#' class='btn-submit d-block mb-2 w-100' onclick='setLanguage(\"ar\")'>عربي</a>";
    output+= " <a  href='#' class='btn-submit d-block w-100' onclick='setLanguage(\"fr\")'>french</a>"
    output+= " </div> ";
    $('.index').html(output);
}
function setLanguage(lang){
  myApp.closePanel();

  showLoader();
  setTimeout(function(){
    window.localStorage.setItem("lang",lang);
   },0);
   setTimeout(function(){
     releaseApp(lang);
   },10);
  //appear loader
}
myApp.onPageAfterAnimation('*',function(e){
  myApp.closePanel();
});
function releaseApp(lang_data){
 //window.localStorage.clear();
// window.localStorage.setItem("lang",lang);
  showLoader();
  console.log(window.localStorage.getItem('lang'));

  if(window.localStorage.getItem('lang')){
    var lang=window.localStorage.getItem("lang");
     myApp.closePanel();

    if(lang=='ar'){
      $$('html').attr('dir','rtl');
      $$('html').attr('class','rtl');
      $$('.panel-reveal.panel_content.menu').removeClass('panel-left');
      $$('.panel-reveal.panel_content.menu').addClass('panel-right');
    }else{
      $$('html').attr('dir','ltr');
      $$('html').removeAttr('class');
      $$('.panel-reveal.panel_content.menu').addClass('panel-left');
      $$('.panel-reveal.panel_content.menu').removeClass('panel-right');
    }
    getBasicUrl(drawHome,lang_data);
    $('.intro_page').html("");//loooader
  }else{
    drawIndex();
    hideLoader();
  }
}
function drawMenu(){
  var output="";
  output+="<div class='list list-block'>";
    output+="<div class='page'>";
        output+="<div class='center logo-div'>";
          output+="<img  class='logo' src='img/logo.jpg' />";
        output+="</div>";
        output+="<ul>";
          output+="<li><a href='templates/home.html' class='item-link item-content panel-close' data-i18n='menu.Home'>menu.Home</a></li>";
          output+="<li><a href='templates/list.html' class='item-link item-content panel-close' data-i18n='menu.HAJJ'>menu.HAJJ</a></li>";
          output+="<li><a href='templates/contactus.html' class='item-link item-content panel-close' data-i18n='menu.ContactUS' >menu.ContactUS</a></li>";
          output+="<li><a href='templates/about.html' class='item-link item-content panel-close' data-i18n='menu.AboutUs' >About Us</a></li>";
          if(!UserData){
            output+="<li><a href='templates/login.html' class='item-link item-content panel-close' data-i18n='menu.Login'>menu.Login </a></li>";
            output+="<li><a href='templates/register.html' class='item-link item-content panel-close' data-i18n='menu.Register' >menu.Register </a></li>";
          }else{
            output+="<li><a href='templates/profile.html' class='item-link item-content panel-close' data-i18n='menu.Profile'>menu.Profil </a></li>";
          }
          var lang=window.localStorage.getItem('lang');
          console.log('lll',lang);
           if(lang=='fr'){
             output+="<li><a href='#' onClick='setLanguage(\"ar\")' class='item-link item-content panel-close'>عربي </a></li>";
           }else{
             output+="<li><a href='#' onClick='setLanguage(\"fr\")' class='item-link item-content panel-close'>French </a></li>";
           }
        output+="</ul>";
    output+="</div>";
  output+="</div>";
  $$('.panel.panel_content.menu').html(output);
}

myApp.onPageBeforeAnimation('contactus',function(e){
//appData['ContactInfo']
   var output="";
      output+="<h3>";
      output+="   <bold  data-i18n='contactus.ILYATOURS'>contactus.ILYATOURS :</bold>";
      if(appData['ContactInfo'].mycontact_address){
        output+="    <span> "+appData['ContactInfo'].mycontact_address+" </span>";
      }
      output+="</h3>";
      output+="  <h3>";
      output+="     <bold data-i18n='contactus.tel'>contactus.tel </bold>";
      output+="     <span>: "+appData['ContactInfo'].mycontact_phone+"</span>";
      output+="    </h3>";
      output+="<h3>";
      output+="   <bold  data-i18n='contactus.email'> contactus.email </bold>";
      output+="     <span>: "+appData['ContactInfo'].mycontact_email+"</span>";
      output+="  </h3>";
      output+="  <h3>";
      output+="     <bold  data-i18n='contactus.web'>contactus.web </bold>";
      output+="     <span>:  "+appData['ContactInfo'].mycontact_web+"</span>";
      output+="  </h3>";
      output+="  <h3>";
      output+="     <bold  data-i18n='contactus.IATA'>contactus.IATA</bold>";
      output+="     <span>:   "+appData['ContactInfo'].mycontact_lat+", "+appData['ContactInfo'].mycontact_long+"</span>";
      output+="  </h3>";
      // output+="  <h3>";
      // output+="     <bold>R.C </bold>";
      // output+="     <span>:   "+appData['ContactInfo'].mycontact_long+"</span>";
      // output+="  </h3>";
      // output+="  <h3>";
      // output+="     <bold>I.F </bold>";
      // output+="     <span>: 03303044</span>";
      // output+="  </h3>";
      // output+="  <h3>";
      // output+="     <bold>T.P  </bold>";
      // output+="     <span>: 25129121</span>";
      // output+="    </h3>";
      // output+="    <h3>";
      // output+="     <bold> CNSS </bold>";
      // output+="       <span>: 6256293</span>";
      // output+="    </h3>";
      // output+="    <h3>";
      // output+="       <bold> ICE </bold>";
      // output+="       <span>: 000016160000083</span>";
      // output+="    </h3>";
      if(appData['ContactInfo'].mycontact_address){
        output+="<h3> "+appData['ContactInfo'].mycontact_address+" </h3>";
      }
      $$('#contactus .info').html(output);

});
myApp.onPageAfterAnimation('contactus',function(e){
  var lang=window.localStorage.getItem('lang');
   requires=['name','email','phone'];
   formId='contactus_form';
  var urlReq=baseUrl+lang+'/api/contact '
  listnerContactFormAction(urlReq);
});
myApp.onPageBeforeAnimation('about',function(e){
  if(appData['AboutInfo']){
    drawAboutUs();
  }else{
    getAbout(drawAboutUs);
  }
  var output="<div class='center_view'><span class='preloader preloader-yellow'></span></div>";

  $$('#about').html(output);
});
function drawAboutUs(){
  var output="";
  output+="<div class='block-title text-center sec-title'>"+appData['AboutInfo'][0].title+"</div>";
  output+="    <div class='block block-strong'>";
  output+="       <p>"+appData['AboutInfo'][0].descrption+"</p>";
  output+="    </div>";
  $$('#about').html(output);

}
myApp.onPageBeforeAnimation('register',function(e){
//appData['ContactInfo']
   var output="";
   output+="<div class='block-title  text-center sec-title my-2' data-i18n='register.Create'>register.Create</div>";
    output+="<div class='mt-3'>";
      output+="<form method='post' class='ajax-submit' id='register_form'>";
      output+="<div class='item-input-wrap row col-100 register_form_fname_parent'>";
                output+="<label data-i18n='register.FirstName'>register.FirstName</label>";
                  output+="<input type='text' name='fname' id='register_form_fname' class='input_text  col-100'>";
                  output+="<span class='col-100 input-clear-button'></span>";
               output+="</div>";
              output+="<div class='item-input-wrap row col-100 register_form_lname_parent'>";
                output+="<label data-i18n='register.LastName'>register.LastName</label>";
                  output+="<input type='text' name='lname' id='register_form_lname' class='input_text  col-100'>";
                  output+="<span class='col-100 input-clear-button'></span>";
             output+="</div>";
             output+="<div class='item-input-wrap row col-100 register_form_phone_parent'>";
               output+="<label data-i18n='register.mobile'>register.mobile</label>";
                 output+="<input type='tel' name='phone' id='register_form_phone' class='input_text  col-100'>"
                 output+="<span class='col-100 input-clear-button'></span>";
                output+="</div>";
             output+="<div class='item-input-wrap row col-100 register_form_email_parent'>";
                output+="<label  data-i18n='register.Email'>register.Email</label>";
                output+="<input type='email' name='email' id='register_form_email' class='input_text  col-100'>";
                output+="<span class='col-100 input-clear-button'></span>";
             output+="</div>";
             output+="<div class='item-input-wrap row col-100 register_form_password_parent'>";
              output+="  <label data-i18n='register.Createpassword'>register.Createpassword</label>";
              output+="  <input type='password' name='password' id='register_form_password' class='input_text  col-100'>";
              output+="  <span class='col-100 input-clear-button'></span>";
             output+="</div>";
              output+="<div class='item-input-wrap row col-100 register_form_conpassword_parent'>";
             output+="    <label data-i18n='register.Confirmpassword'>register.Confirmpassword</label>";
               output+="  <input type='password' name='conpassword' id='register_form_conpassword' class='input_text  col-100'>";
               output+="  <span class='col-100 input-clear-button'></span>";
              output+="</div>";
             output+="<div class='item-input-wrap col-100'>";
             output+="    <button type='submit' name='submit' value='Get started' class='col-100 btn-submit' data-i18n='register.Getstarted'>register.Getstarted</button>";
             var lang=window.localStorage.getItem('lang');
             output+="    <input type='hidden' name='lang' value='"+lang+"' >";
            output+=" </div>";
            output+=" <div class='success_msg hidden' data-i18n='contactus.Success'>contactus.success </div>";
          output+="</form>";
          output+="<div class='my-2 text-center'>";
          output+="   <div class='block-title  text-center sec-title' data-i18n='register.Loginwith'>register.Loginwith</div>";
          output+="   <a href='' class='loginBtn loginBtn--facebook'>";
          output+="   <span class='fa fa-facebook ico'> </span> <span data-i18n='register.fblogin'>register.fblogin</span>";
          output+="   </a>";
          output+="   <p class='bold sce-title block-title  text-center sec-title' data-i18n='register.or'> register.or </p>";
          output+="   <a href='' class='loginBtn'>";
          output+="   <span class='fa fa-google ico'> </span> <span data-i18n='register.googlelogin'>register.googlelogin</span>";
          output+="   </a>";
        output+="  </div>";
       output+="</div>";
      $$('#register').html(output);

});
myApp.onPageBeforeAnimation('login',function(e){
//appData['ContactInfo']
   var output="";
   output+="<div class='login padded-section' id='login'>";
       output+="   <div class='block-title  text-center sec-title my-1' data-i18n='login.Account'>login.Account</div>";
       output+="   <div class='mt-3'>";
       output+="      <form method='post' class='ajax-submit' id='login_form'>";
       output+="         <div class='item-input-wrap row col-100 login_form_email_parent'>";
       output+="            <label data-i18n='login.Email'>login.Email</label>";
       output+="            <input type='email' name='email' id='login_form_email' class='input_text  col-100'>";
       output+="            <span class='col-100 input-clear-button'></span>";
       output+="         </div>";
      output+="          <div class='item-input-wrap row col-100 login_form_password_parent'>";
        output+="          <label data-i18n='login.Password'>login.Password</label>";
      output+="            <input type='password' name='password' id='login_form_password' class='input_text  col-100'>";
      output+="            <span class='col-100 input-clear-button'></span>";
      output+="         </div>";
      output+="         <div class='col-100 form-checkbox item-input-wrap list list-block mt-1 item-input-wrap  col-100'>";
      output+="            <label class='item-checkbox label-checkbox item-content'>";
      output+="               <input type='checkbox' name='demo-checkbox' value='Remember Password' checked='checked'/>";
      output+="               <i class='icon icon-checkbox'></i>";
      output+="               <div class='item-inner'>";
      output+="                  <div class='item-title' data-i18n='login.RememberPassword'>login.RememberPassword</div>";
      output+="               </div>";
      output+="            </label>";
      output+="         </div>";
      output+="              <div class='item-input-wrap  mt-1 col-100'>";
      var lang=window.localStorage.getItem('lang');
      output+="    <input type='hidden' name='lang' value='"+lang+"' >";
      output+="    <button type='submit' name='submit' value='Get started' class='col-100 btn-submit' data-i18n='login.Send'>login.Send</button>";

    //  output+="                 <input type='submit' name='submit' value='Send' class='col-100 btn-submit'>";
      output+="              </div>";
      output+="           </form>";
      output+="           <div class='my-2'>";
      output+="              <a href='templates/forgot_password.html' class='mb-1 d-block'  data-i18n='login.Forgotyourpassword'>login.Forgotyourpassword?</a>";
      output+="              <p>Don't have an account? <a href='templates/register.html' class='bold'  data-i18n='login.Createyouraccount'>login.Createyouraccount</a></p>";
      output+="           </div>";
      output+="           <div class='my-2 text-center'>";
      output+="              <div class='block-title  text-center sec-title'   data-i18n='login.Loginwith'>login.Loginwith</div>";
      output+="              <a href='' class='loginBtn loginBtn--facebook'>";
      output+="              <span class='fa fa-facebook ico'> </span><span data-i18n='login.LoginwithFacebook'>login.LoginwithFacebook</span>";
      output+="              </a>";
      output+="              <p class='bold sce-title block-title  text-center sec-title'  data-i18n='login.OR'> login.OR </p>";
      output+="              <a href='' class='loginBtn'>";
      output+="              <span class='fa fa-google ico'> </span> <span data-i18n='login.LoginwithGoogle'> login.LoginwithGoogle</span>";
      output+="              </a>";
      output+="           </div>";
      output+="        </div>";
      output+="     </div>";
      $$('#login').html(output);

});

myApp.onPageAfterAnimation('register',function(e){
  var lang=window.localStorage.getItem('lang');
   requires=['fname','lname','phone','email','password','conpassword'];
   formId='register_form';
  var urlReq=baseUrl+lang+'/api/sign_up';
  listnerRegisterFormAction(urlReq);
});
myApp.onPageAfterAnimation('login',function(e){
  var lang=window.localStorage.getItem('lang');
   requires=['email','password'];
   formId='login_form';
  var urlReq=baseUrl+lang+'/api/login';
  listnerLoginFormAction(urlReq);
});

myApp.onPageBeforeAnimation('list',function(e){
  var output="";
  output+='<div class="block-title text-center sec-title my-1" data-i18n="list.HAJJ">list.HAJJ</div>';
     output+='<form class="row filter-list mb-1">';
       output+='    <div class="m-col col-20">';
        output+="<a href='#' class='col-100 item-link smart-select ' data-open-in='picker'  data-back-on-select='true'>";
             output+="    <select name='country' id='country'>";
                   for(var i=0;i<  appData['Countries'].length;i++){
                     var country=appData['Countries'][i];
                     output+=" <option value='"+country.id+"' data-i18n='profile.Select'>"+country.title+" </option>";
                   }
               output+="     </select> ";
              output+="  <div class='item-content row col-100'>";
              output+="     <div class='item-inner'>";
              output+="        <div class='item-after' data-i18n='list.Country' >list.Country</div>";
              output+="     </div>";
              output+="  </div>";
          output+="   </a>";
          output+=" </div> ";

          output+="<div class='m-col col-20'>";
          output+="   <a href='#' class='col-100 item-link smart-select ' data-open-in='picker'  data-back-on-select='true'>";
            output+="    <select name='' id=''>";
            output+="       <option value='' data-i18n=''>City </option>";
            output+="       <option value='' >City</option>";
            output+="       <option value='' >City</option>";
              output+="  </select>";
              output+="  <div class='item-content row col-100'>";
                output+="   <div class='item-inner'>";
                output+="      <div class='item-after' data-i18n='list.City'>list.City</div>";
                output+="   </div>";
              output+="  </div>";
            output+=" </a>";
        output+="  </div>";

        output+="  <div class='m-col col-20'>";
          output+="   <a href='#' class='col-100 item-link smart-select ' data-open-in='picker'  data-back-on-select='true'>";
          output+="      <select name='' id=''>";
          output+="         <option value='' data-i18n=''>Budget </option>";
            output+="       <option value='' >Budget</option>";
            output+="       <option value='' >Budget</option>";
            output+="    </select>";
            output+="    <div class='item-content row col-100'>";
            output+="       <div class='item-inner'>";
                output+="      <div class='item-after'  data-i18n='list.Select'>list.Select</div>";
              output+="     </div>";
            output+="    </div>";
        output+="     </a>";
        output+="  </div>";

          output+="   <div class='m-col col-20'>";
          output+="        <a href='#' class='col-100 item-link smart-select ' data-open-in='picker'  data-back-on-select='true'>";
            output+="       <select name='' id=''>";
              output+="        <option value='' data-i18n=''>location </option>";
              output+="        <option value='' >location</option>";
              output+="        <option value='' >location</option>";
              output+="     </select>";
              output+="     <div class='item-content row col-100'>";
                output+="      <div class='item-inner'>";
                output+="         <div class='item-after' data-i18n='list.location'>list.location</div>";
                output+="      </div>";
                output+="   </div>";
               output+=" </a>";
          output+="   </div>";

          output+="   <div class='m-col col-20'>";
        output+="        <a href='' class='filter-btn' href='' data-i18n='list.Filter'>list.Filter </a>";
        output+="     </div>";
      output+="    </form>";

      for(var i=0;i<appData['hijList'].length;i++){
          var item=appData['hijList'][i];
          output+="  <div class='list_item'>";
            output+=item_List(item);
          output+="  </div>";

      }

  $$('#list').html(output);

});
function item_List(item){
  var output="";
  output+=" <div class='img-con'>";
  output+=" <img class='w-100' src='"+item.image+"'>";
  output+="        <span class='price'>"+item.price+" <small>"+item.currency+"</small> </span>";
  output+="   </div>";
  output+="   <div class='title bold'>"+item.title+"</div>";
  output+="   <div class='date-rating d-flex justify-content-between  align-items-center'>";
  output+="      <div class='date' data-i18n='home.StarsFrom'>home.StarsFrom "+item.start_from+"</div>";
  output+="      <div class='rating not-click'>";
  output+="       <span class='active'>☆</span><span class='active'>☆</span><span>☆</span><span>☆</span><span>☆</span>";
  output+="    </div>";
  output+="   </div>";
  output+="   <a href='templates/list_details.html?id="+item.id+"' class='view-btn btn' data-i18n='list.View'>list.View  </a>";

return output;
}
var trip_list=[];
myApp.onPageBeforeAnimation('list_details',function(e){
  var id=mainView.activePage.query.id;
  if(id){
    //load Data
    if(trip_list.length>0&& getTripByID(mainView.activePage.query.id)){
      drawTripDetails(getTripByID(mainView.activePage.query.id))
    }else{
      getTripDetails(id,drawTripDetails);
    }
  }

});
function getTripByID(id){
  for(var i=0;i<trip_list.length;i++){
    if(id==trip_list[i].id){
      return trip_list[i];
      break;
    }
  }
}
function getTripDetails(id,callback){
  var lang=window.localStorage.getItem('lang');
  var urlReq=baseUrl+lang+'/api/trip_details';

  $.post(urlReq,
    {
      "lang":lang,
      "id":id,
    },
    function(data, status){
      data = JSON.parse(data);
      console.log('data',data);
      if(data.result.success){
        trip_list.push(data.response);
        callback(data.response);
      }
    });

}
function dateFormate(date){
  var mydate = new Date(date);
  var lang=window.localStorage.getItem('lang');
  if(lang=='fr'){
    var month = ["janvier", "février", "mars", "avril", "mai", "juin","juillet", "aout", "septembre", "octobre", "novembre", "décembre"][mydate.getMonth()];

  }else{
    var month = ["يناير	", "فبراير	", "مارس	", "أبريل", "مايو	", "يونيو","يوليو", "أغسطس", "سبتمبر", "أكتوبر	", "نوفمبر", "ديسمبر	"][mydate.getMonth()];

  }
  var str = mydate.getDay()+" "+month + ' ' + mydate.getFullYear();
   return str;
}
function drawTripDetails(data){
  console.log('data',data);

  var output="";
    output+="<div class='text-center my-1'>";
      output+="<h4 class='sec-title text-center my-0'>"+data.package.title+"</h4>";
    //  output+="<h4 class='sec-title text-center my-0'>"+dateFormate(data.package.entry_date)+"</h4>";
    output+="</div>";
    output+="<div class='date-rating d-flex justify-content-between  align-items-center'>";
    //  Du 04 au 12 Aout 2018

    output+="  <div class='date block-title'> <span data-i18n='details.from'> details.from </span>  "+dateFormate(data.package.from_date)+"<span data-i18n='details.to'> details.to </span>  "+dateFormate(data.package.to_date)+"</div>";
    output+="  <div class='rating'>";
    output+="     <span class='active'>☆</span><span class='active'>☆</span><span>☆</span><span>☆</span><span>☆</span>";
    output+="  </div>";
    output+="</div>";
    output+=" <div class='swiper-container swiper-init mt-1' >";
    output+="    <div class='swiper-wrapper'>";
    for(var i=0;i<data.packageGallery.length;i++){
      output+="   <div class='swiper-slide' ><img class='w-100' src='"+data.packageGallery[i].image+"'></div>";
    }
    output+="    </div>";
    output+="    <div class='swiper-pagination'></div>";
    output+="    <span class='price'> "+data.package.price_adults +"  <small>"+data.myCurrency+"</small> </span>";
    output+="    <div class='add-to-fav'><i class='fa fa-heart' > </i></div>";
    output+=" </div>";
    output+="<div class='jour'>";

    output+="<div class='block  list-block accordion-list custom-accordion my-3'>"
        // output+="<div class='accordion-item'>";
        //     output+="<div class='accordion-item-toggle'>";
        //     output+="   <i class='icon icon-plus'>+</i>";
        //     output+="   <i class='icon icon-minus'>-</i>";
        //     output+="   <span class='sec-title text-center my-0'>le programme du voyage</span>";
        //     output+="</div>";
        //     output+="<div class='accordion-item-content'>";
        //     output+="   <ul class='my-3  list-unstyled jours-programm'>";
        //
        //     output+="      <li class='my-1'>";
        //     output+="         <strong class='sec-title small my-0 colored my-0'>JOUR 1</strong>";
        //     output+="         <h2 class='sec-title small my-0'> CASABLANCA  - LISBONNE SUR LE VOL AT 982 A 10H00 / ARR A 11H20</h2>";
        //     output+="         <h4 class='h4 my-0 s-details'>  A l’arrivée, accueil par notre correspondant et transfert à votre hôtel. Installation dans vos chambres. Dîner libre et nuit.";
        //     output+="         </h4>";
        //     output+="      </li>";
        //
        //     output+="  </ul>";
        //     output+="</div>";
        // output+="</div>";
           // <div class="accordion-item">
           //    <div class="accordion-item-toggle">
           //       <i class="icon icon-plus">+</i>
           //       <i class="icon icon-minus">-</i>
           //       <span class='sec-title text-center my-0'>Hôtels prévu</span>
           //    </div>
           //    <div class="accordion-item-content">
           //       <div class="card data-table">
           //          <table class="table table-striped">
           //             <thead>
           //                <tr>
           //                   <th>Villes</th>
           //                   <th>Hôtels 4*</th>
           //                   <th>Nuits</th>
           //                </tr>
           //             </thead>
           //             <tbody>
           //                <tr>
           //                   <td>LISBONNE</td>
           //                   <td>HOTEL FENIX URBAN</td>
           //                   <td>04</td>
           //                </tr>
           //                <tr>
           //                   <td>LISBONNE 1</td>
           //                   <td>HOTEL FENIX URBAN 1</td>
           //                   <td>04 1</td>
           //                </tr>
           //                <tr>
           //                   <td>LISBONNE 2</td>
           //                   <td>HOTEL FENIX URBAN 3</td>
           //                   <td>04 2</td>
           //                </tr>
           //             </tbody>
           //          </table>
           //       </div>
           //       <div class="card data-table">
           //          <table class="table ">
           //             <thead>
           //                <tr>
           //                   <th>Date de départ</th>
           //                   <th>Par personne en <br>chambre double </th>
           //                   <th>Chambre Single</th>
           //                   <th>Lit enfant moinsde <br> 12 ans</th>
           //                </tr>
           //             </thead>
           //             <tbody>
           //                <tr>
           //                   <td>Du 04 au 12 Aout 2018</td>
           //                   <td>14 000 dhs</td>
           //                   <td>18 900 dhs</td>
           //                   <td>11 900 DHS</td>
           //                </tr>
           //             </tbody>
           //          </table>
           //       </div>
           //    </div>
           // </div>
            output+="  <div class='accordion-item'>";
            output+="    <div class='accordion-item-toggle'>";
            output+="       <i class='icon icon-plus'>+</i>";
            output+="       <i class='icon icon-minus'>-</i>";
            output+="       <span class='sec-title text-center my-0' data-i18n='details.prices'> details.prices </span>";
            output+="    </div>";
            output+="    <div class='accordion-item-content'>";
            output+="       <div class='my-3'>";
            output+="          <strong class='sec-title' data-i18n='details.adultes'>  details.adultes :</strong>";
            output+="          <ul class='my-1 list-unstyled list-theme'>";
            output+="             <li> "+data.package.price_adults+" "+data.myCurrency+"</li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique </li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique </li>";
            output+="          </ul>";
            output+="          <strong class='sec-title'  data-i18n='details.Children'>  details.Children :</strong>";
            output+="          <ul class='my-1 list-unstyled list-theme'>";
            output+="             <li> "+data.package.price_enfants+" "+data.myCurrency+"</li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique </li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique</li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique</li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique</li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique</li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique</li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique</li>";
            output+="          </ul>";
            output+="          <strong class='sec-title' data-i18n='details.Infants'>  details.Infants :</strong>";
            output+="          <ul class='my-1 list-unstyled list-theme'>";
            output+="             <li> "+data.package.price_children+" "+data.myCurrency+"</li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique </li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique</li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique</li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique</li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique</li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique</li>";
            // output+="             <li> Le billet d’avion Casablanca/Lisbonne/Porto/Casablanca avec la Royal Air Maroc en classe économique</li>";
            output+="          </ul>";
            output+="       </div>";
            output+="    </div>";
            output+=" </div>";
            output+="  <div class='accordion-item'>";
            output+="    <div class='accordion-item-toggle'>";
            output+="       <i class='icon icon-plus'>+</i>";
            output+="       <i class='icon icon-minus'>-</i>";
            output+="       <span class='sec-title text-center my-0'  data-i18n='details.police'> details.police </span>";
            output+="    </div>";
            output+="    <div class='accordion-item-content'>";
            output+="       <div class='my-3'>";
            output+="          <ul class='my-1 list-unstyled list-theme'>";
            output+="             <li> "+ data.package.policy +"</li>";
            output+="          </ul>";
            output+="       </div>";
            output+="    </div>";
            output+=" </div>";
          output+="<div class='accordion-item'>";
          output+="   <div class='accordion-item-toggle'>";
          output+="      <i class='icon icon-plus'>+</i>";
          output+="      <i class='icon icon-minus'>-</i>";
          output+="      <span class='sec-title text-center my-0'  data-i18n='details.Inclusions' >details.Inclusions</span>";
          output+="   </div>";
          output+="     <div class='accordion-item-content'>";
          output+="        <div class='my-3 '>";
          output+="           <h2 class='sec-title small my-0' data-i18n='details.Inclusi'>details.Inclusi</h2>";
          output+="           <ul class='list-unstyled inclusions'>";
            for(var i=0;i<data.packageInclusions.length;i++){
              output+="<li>"+data.packageInclusions[i].title+"</li>";
            }
          output+="           </ul>";
          output+="        </div>";
            output+="        <div class='my-3 '>";
            output+="           <h2 class='sec-title small my-0' data-i18n='details.Exclusions'>details.Exclusions</h2>";
            output+="           <ul class='list-unstyled exclusions'>";
            for(var i=0;i<data.packageExclusions.length;i++){
              output+="<li>"+data.packageExclusions[i].title+"</li>";
            }
            output+="           </ul>";
            output+="        </div>";
            output+="     </div>";
            output+="  </div>";
          output+=" </div>";
       output+="</div>";
     output+="<div><a href='templates/booking1.html' class='view-btn book-now btn' data-i18n='details.BookNow'>details.BookNow</a></div>";

      output+="<div class='my-3'>";
     output+="    <h4 class='sec-title  my-0' data-i18n='details.Reviews'>details.Reviews</h4>";
     output+="    <div class='my-3 px-2'>";
     output+="       <form class='row'>";
       output+="        <div class='item-input-wrap col-100'>";
       output+="           <textarea  class='col-100' data-i18n='[placeholder]details.WriteReview' placeholder='details.WriteReview'></textarea>";
     output+="          </div>";
       output+="        <div class='item-input-wrap  mt-1 col-100'>";
       output+="    <button type='submit' name='submit' value='Get started' class='col-100 btn-submit' data-i18n='details.Send'>details.Send</button>";

      // output+="           <input type='button' name='submit' value='Send' class='col-100 btn-submit'>";
       output+="        </div>";
       output+="     </form>";
       output+="     <div class='list-block media-list no-overflow-text my-30'>";
       output+="        <ul>";
       output+="           <li>";
       output+="              <div class=' item-content'>";
         output+="               <div class='item-media'>";
         output+="                  <img src='img/user_blank.jpg' width='60'>";
         output+="               </div>";
         output+="               <div class='item-inner'>";
         output+="                  <div class='item-title-row'>";
         output+="                     <div class='item-title' data-i18n='details.UserName'>details.UserName</div>";
         output+="                  </div>";
         output+="                  <div class='item-subtitle'>21/04/2019</div>";
         output+="                  <div class='item-text'>";
         output+="                     Exercitation pariatur incididunt in ad, amet consectetur velit. Consectetur in eiusmod velit dolore fugiat occaecat quis voluptate ullamco elit eiusmod cillum in enim minim, cillum aute aliqua. In, reprehenderit dolore, sit sunt aliqua ut ";
         output+="                  </div>";
         output+="               </div>";
         output+="            </div>";
         output+="         </li>";
       output+="           <li>";
       output+="              <div class=' item-content'>";
         output+="               <div class='item-media'>";
           output+="                <img src='img/user_blank.jpg' width='60'>";
           output+="             </div>";
           output+="             <div class='item-inner'>";
           output+="                <div class='item-title-row'>";
           output+="                     <div class='item-title' data-i18n='details.UserName'>details.UserName</div>";
             output+="              </div>";
             output+="              <div class='item-subtitle'>21/04/2019</div>";
             output+="              <div class='item-text'>";
             output+="                 Exercitation pariatur incididunt in ad, amet consectetur velit. Consectetur in eiusmod velit dolore fugiat occaecat quis";
             output+="              </div>";
             output+="           </div>";
             output+="        </div>";
             output+="     </li>";
           output+="    </ul>";
         output+="   </div>";
       output+="  </div>";
      output+="</div>";


     output+="<div class='my-3 row related-packages'>";
      output+="<h4 class='sec-title col-100 ' data-i18n='details.RelatedPackages'>details.RelatedPackages</h4>";

      for(var i=0;i<data.relatedPackages.length;i++){
        output+="  <div class='list_item col-50'>";
        output+="     <div class='img-con'>";
        output+="        <img class='w-100' src='"+baseUrl+data.relatedPackages[i].full_path_image+"'>";
        output+="        <span class='price'>"+data.relatedPackages[i].price_adults+" <small>"+data.myCurrency+"</small> </span>";
        output+="     </div>";
        output+="     <div class='title bold'>"+data.relatedPackages[i].title+"</div>";
        output+="     <div class='date-rating d-flex justify-content-between  align-items-center'>";
        output+="        <div class='date'>Stars From "+data.relatedPackages[i].entry_date+"</div>";

        output+="     </div>";
        output+="     <a href='templates/list_details.html?id="+data.relatedPackages[i].id+"' class='view-btn btn' href='' data-i18n='details.View'>details.View </a>";
        output+="  </div>";

      }
      output+="  </div>";


  $$('#list_details').html(output);
}
function drawHomePage(){
  var output="";
    output+='<div class="nav_search advanced_search row">';
         output+='<div class="col-100">';
          output+='  <span class="white-txt  text-center sec-title">';
            output+='   <h3 class="my-0"  data-i18n="home.EXPLORENEW">home.EXPLORENEW </h3>';
            output+='   <h3 class="my-0"  data-i18n="home.DESTINATION">home.DESTINATION</h3>';
            output+='</span>';
          output+='  <div class="white-txt  text-center my-3"  data-i18n="home.Discover">';
              output+=' home.Discover  <br/>';
              output+='<span  data-i18n="home.Tours"> home.Tours</span>';
          output+='  </div>';
         output+=' </div>';
      output+=' <form class="col-100">';
        output+='  <div class="mb-1"> ';
            output+='  <a href="#" class="col-100 item-link smart-select main-select" data-open-in="picker"  data-back-on-select="true">';
                output+='  <select name="categories" id="s_Language_settings">';
                  for(var i=0;i<appData['Categories'].length;i++){
                    var category=appData['Categories'][i];
                    console.log('category.title');
                    output+='  <option value="'+category.id+'" >'+category.title+' </option>  ';
                  }
                  output+='</select>';
                output+='  <div class="item-content row col-100">';
                    output+=' <div class="item-inner">';
                    output+='    <div class="item-after" data-i18n="home.Select" >home.Select</div>';
                    output+=' </div>';
                  output+='</div>';
              output+=' </a>';
          output+='  </div>';
          output+="<div class='mb-1'>";
          output+="   <label data-i18n='home.DESTINATION'>home.DESTINATION</label>";
          output+="   <a href='#' class='col-100 item-link smart-select ' data-open-in='picker'  data-back-on-select='true'>";
            output+="    <select name='country' id='country'>";
                  for(var i=0;i<  appData['Countries'].length;i++){
                    var country=appData['Countries'][i];
                    output+=" <option value='"+country.id+"' >"+country.title+" </option>";
                  }

              output+="     </select> ";
                  output+="<div class='item-content row col-100'>";
                  output+="   <div class='item-inner'>";
                  output+="      <div class='item-after' data-i18n='home.Select' >home.Select</div>";
                  output+="   </div>";
                output+="  </div>";
              output+=" </a>";
          output+="   </div> ";
          output+="     <div class='mb-1'> ";
          output+="   <div class='row'> ";
              output+="       <div class='col-50'>";
              output+="          <label data-i18n='home.TravelFrom'>home.TravelFrom:</label>";
            output+="   <input type='text' name='from' data-i18n='[placeholder]home.Selectdate'  placeholder='home.Selectdate' class='input_text date-pic  calender '>";
              output+="       </div>";
                output+="   <div class='col-50'>";
                output+="      <label  data-i18n='home.to'> home.to:</label>";
                output+="      <input type='text' name='to'  data-i18n='[placeholder]home.Selectdate'  placeholder='home.Selectdate' class='input_text date-pic calender2 '>";
                output+="   </div>";
            output+="    </div>";
          output+="   </div>";
          output+=" <div class='col-100 row mb-2'>";
            output+="  <div class='col-33'>";
            output+="     <label  data-i18n='home.Room'>home.Room</label>";
              output+="    <a href='#' class='col-100 item-link smart-select ' data-open-in='picker'  data-back-on-select='true'>";
                output+="     <select name='room' id='room'>";
                output+="        <option value='' data-i18n='home.Select'>home.Select </option>";
                output+="        <option value='1' >1</option>";
                output+="        <option value='2' >2</option>";
                output+="     </select>";
                output+="     <div class='item-content row col-100'>";
                output+="        <div class='item-inner'>";
                output+="           <div class='item-after' data-i18n='home.Select' >home.Select</div>";
                output+="        </div>";
                output+="     </div>";
              output+="    </a>";
          output+="     </div>";
          output+="   <div class='col-33'>";
          output+="      <label  data-i18n='home.Adults'>home.Adults</label>";
          output+="      <a href='#' class='col-100 item-link smart-select ' data-open-in='picker'  data-back-on-select='true'>";
            output+="       <select name='adults' id='adults'>";
            output+="          <option value='' data-i18n='home.Select'>home.Select </option>";
            output+="          <option value='1' >1</option>";
            output+="          <option value='2' >2</option>";
              output+="     </select>";
              output+="     <div class='item-content row col-100'>";
              output+="        <div class='item-inner'>";
              output+="           <div class='item-after' data-i18n='home.Select' >home.Select</div>";
              output+="        </div>";
              output+="     </div>";
              output+="  </a>";
            output+=" </div>";
              output+=" <div class='col-33'>";
              output+="    <label data-i18n='home.Child'>home.Child</label>";
                output+="  <a href='#' class='col-100 item-link smart-select ' data-open-in='picker'  data-back-on-select='true'>";
                output+="     <select name='child' id='child'>";
                output+="        <option value='' data-i18n='home.Select'>home.Select </option>";
                output+="        <option value='1' >1</option>";
                  output+="      <option value='2' >2</option>";
                  output+="   </select>";
                output+="     <div class='item-content row col-100'>";
                    output+="     <div class='item-inner'> ";
                    output+="        <div class='item-after' data-i18n='home.Select'>home.Select</div> ";
                    output+="     </div> ";
                    output+="</div>";
                output+="  </a>";
              output+=" </div>";
          output+="  </div>";
          output+="    <input type='submit' name='submit'  data-i18n='[value]home.Search' value='home.Search'  class='input_text  btn-submit calender'>";
        output+="   </form>";
    output+="    </div>";
  output+="    <div class='to_be_padded_slider mb-2 w-100 hidden-overflow'>";
    output+="     <h3 class='sec-title text-center' data-i18n='home.BESTSALES' >home.BESTSALES</h3>";
    output+="     <div class='swiper-container   home-slider  best-sales swiper-init'>";
output+="  <div class='swiper-wrapper'>";

  for(var i=0;i<appData['TripLists'].length;i++){
    var item=appData['TripLists'][i];

      output+="         <div class='swiper-slide'>";
             output+=item_List(item);
          output+="     </div>";


        }
            output+="    </div>";
            output+="    <div class='swiper-pagination'></div>";
           output+="  </div>";
      output+="    </div>";

      output+="    <div class='cover haj-omra-section-home' style='background-image:url(img/test/29.png)'>";
        output+="     <div class='to_be_padded_slider  w-100 hidden-overflow'>";



        output+="        <h3 class='sec-title text-center white-txt' data-i18n='home.HAJJ' >home.HAJJ</h3>";
        output+="        <div class='swiper-container  white-txt home-slider  best-sales swiper-init' data-speed='400' data-space-between='40' data-pagination='.swiper-pagination'>";
        output+="           <div class='swiper-wrapper mb-2'>";

          for(var i=0;i<appData['TripListsHajj'].length;i++){
            var item=appData['TripListsHajj'][i];

              output+="              <div class='swiper-slide'>";
                      output+=item_List(item);
              output+="            </div>";

          }
        output+="      </div>";
          output+="       <div class='swiper-pagination'></div>";
        output+="      </div>";
        output+="   </div>";
      output+="  </div>";
  $$('#home_data').html(output);
  var mySwiper = myApp.swiper('.swiper-container', {
    pagination:'.swiper-pagination'
  });

}
myApp.onPageBeforeAnimation('home',function(e){
drawHomePage();

});

function listnerContactFormAction(urlReq){
  console.log('urlReq',urlReq);
  $$('#'+formId).attr('action',urlReq);
  $$('#'+formId).on('beforeSubmit',submitForm);
  //number_1','number_2','number_3','number_4'
  $$('#'+formId).on('submitted',submitFormResult);

}
function listnerRegisterFormAction(urlReq){
  console.log('urlReq',urlReq);
  $$('#'+formId).attr('action',urlReq);
  $$('#'+formId).on('beforeSubmit',submitForm);
  $$('#'+formId).on('submitted',submitFormResult);
}
function listnerLoginFormAction(urlReq){
  console.log('urlReq',urlReq);
  $$('#'+formId).attr('action',urlReq);
  $$('#'+formId).on('beforeSubmit',submitForm);
  $$('#'+formId).on('submitted',submitFormResult);
}
function submitFormResult(e){
  var xhr = e.detail.xhr; // actual XHR object
  var data = e.detail.data; // Ajax response from action file
  data = JSON.parse(data);
  console.log('data',data);
  if(data.result.success==true){
    $$('#'+formId).find('.btn-submit .preloader').remove();

    $$('#'+formId).find('.input-clear-button').html('');
    $$('#'+formId).find('.success_msg').removeClass('hidden');
    if(formId=='register_form'){
       var user={};
       user.name=$("#register_form #register_form_fname").val()+" "+$("#register_form #register_form_lname").val();
       user.email=$("#register_form #register_form_email").val();
       user.password=$("#register_form #register_form_password").val();
       user.phone=$("#register_form #register_form_phone").val();

      window.localStorage.setItem("User",JSON.stringify(user));
      drawMenu();
      mainView.router.loadPage('templates/home.html');
    }
    if(formId=='login_form'){
      var user=data.response;
      console.log('$("#login_form #login_form_password").val()',$("#login_form #login_form_password").val());
      console.log('user',user);
      user.password=$("#login_form #login_form_password").val();
      window.localStorage.setItem("User",JSON.stringify(user));
      drawMenu();
      mainView.router.loadPage('templates/home.html');
    }
  }else{
    showError(data.result.message);
  }
}
function showError(msg){
  $$('#'+formId).find('.input-clear-button').html('');
  var arr = Array.from(Object.keys(msg), k=>msg[k]);
  if(arr.length>0){
    for (var k in msg){
      $$('#'+formId+' .'+formId+'_'+k+'_parent').find('.input-clear-button').html(msg[k]);
    }
  }

}

function submitForm(e){
  var xhr = e.detail.xhr; // actual XHR object
   var data = e.detail.data; // Ajax response from action file
   console.log('lll',xhr);
   document.activeElement.blur();
   if(checkRequires(requires,formId)){
     console.log('lll'.requires);
     $$('#'+formId).find('.input-clear-button').html('');
     $$('#'+formId).find('.btn-submit').append('<span class="preloader preloader-white"></span>');


   }else{
     console.log('dddd');
     setTimeout(function(){   xhr.abort(); }, 0);
   }
    return false;
}

function checkRequires(requires,formId){
  var flag=true;
  $$('#'+formId).find('.input-clear-button').html('');
  for(var i=0;i<requires.length;i++){
    if(!$$('#'+formId+' #'+formId+'_'+requires[i]).val()){
      $$('#'+formId+' .'+formId+'_'+requires[i]+'_parent').find('.input-clear-button').html('<span  data-i18n="validation.DataRequired" >validation.DataRequired .</span>');
      flag=false;
    }
  }
  if(formId=='register_form'){
    if($$('#'+formId+' #'+formId+'_'+'conpassword').val()!=$$('#'+formId+' #'+formId+'_'+'password').val()){
      console.log(formId+'formId');
      $$('#'+formId+' .'+formId+'_'+'conpassword'+'_parent').find('.input-clear-button').html('<span  data-i18n="validation.Passwordnot" >validation.Passwordnot</span>');
      flag=false;
    }
  }
  return flag;
}

function getTripList(callback){
  trip_page_number++;
  var lang=window.localStorage.getItem('lang');
  var urlReq=baseUrl+lang+'/api/trip_lists';

  $.post(urlReq,
    {
      "lang":lang,
      "page_number":trip_page_number,
    },
    function(data, status){
      data = JSON.parse(data);
      if(data.result.success){
        appData['trips']=data.response;
      }
      hideLoader();
      console.log('appdata',appData);
    });
  }

  function getAbout(callback){
    var lang=window.localStorage.getItem('lang');

    var urlAboutInfo=baseUrl+lang+'/api/aboutus';
    $.post(urlAboutInfo, {
      "lang":lang,
    },function(data, status) {
      data = JSON.parse(data);
      if(data.result.success){
        appData['AboutInfo']=data.response;

          callback();
      }
    });
  }
  function getDate(callback,lang_data){

    var lang=window.localStorage.getItem('lang');
    var countries_lists=baseUrl+lang+'/api/countries_lists';
    var urlReq=baseUrl+lang+'/api/categories_lists';
    var urlReqtripLists=baseUrl+lang+'/api/trip_lists';
    var urlReqHajj=baseUrl+lang+'/api/trip_lists_hajj';
    var urlContactInfo=baseUrl+lang+'/api/contactInfo';

    $.when(
      // Get the HTML
      $.post(countries_lists,{
        "lang":lang,
      },function(data, status) {
        data = JSON.parse(data);
        if(data.result.success){
          appData['Countries']=data.response;
        }
      }),
      $.post(urlReq, {
        "lang":lang,
      },function(data, status) {
        data = JSON.parse(data);
        if(data.result.success){
          appData['Categories']=data.response;
        }
        //  callback();
      }),
      $.post(urlReqHajj, {
        "lang":lang,
        "catId":16,
        "per_page":4,
      },function(data, status) {
        data = JSON.parse(data);
        if(data.result.success){
          appData['TripListsHajj']=data.response;
        }
        //  callback();
      }),
      $.post(urlReqtripLists, {
        "lang":lang,
      //  "catId":16,
        "per_page":4,
      },function(data, status) {
        data = JSON.parse(data);
        if(data.result.success){
          appData['TripLists']=data.response;
        }
        //  callback();
      }),
      $.post(urlContactInfo, {
        "lang":lang,
      },function(data, status) {
        data = JSON.parse(data);
        if(data.result.success){
          appData['ContactInfo']=data.response;
        }
        //  callback();
      }),

      $.post(urlReqtripLists, {
        "lang":lang,
        "catId":16,
        "per_page":20,
      },function(data, status) {
        data = JSON.parse(data);
        if(data.result.success){
          appData['hijList']=data.response;
        }
        //  callback();
      })
      // Get the JS
      //  $.getScript("/assets/feature.js")
    ).then(function() {
      if(lang_data!=null){
        console.log('lang_data',lang_data);
        displayLanguage();
        mainView.router.navigate(mainView.router.currentRoute.url, {
          ignoreCache: true,
          reloadCurrent: true
        });

      //  mainView.router.refreshPage();
      }else{
        console.log('lang_data',lang_data);
        drawHome();
      }
      drawMenu();
      displayLanguage();
      hideLoader();


    });
  //  hideLoader();
  }
  function drawHome(){
    if(mainView.activePage.name ==='home'){
      drawHomePage();
    }else{
      mainView.router.loadPage('templates/home.html');
    }
  }


  function getBasicUrl(callback,lang_data){
  //  getTripList();
    getDate(callback,lang_data);
  }

  function showLoader(){
    $$('.loader-bg').removeClass('hidden');
  }
  function hideLoader(){
    $$('.loader-bg').addClass('hidden');
  }
  var baseUrl='http://gateoflaw.com/App2/';
  releaseApp(null);
