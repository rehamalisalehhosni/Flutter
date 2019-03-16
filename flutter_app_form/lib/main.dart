import 'package:flutter/material.dart';

void main() => runApp(new application());

class application extends StatefulWidget {
  @override
  _applicationState createState() => _applicationState();
}

class _applicationState extends State<application> {
  String ptext='';
  bool cbool=true;
  int  rvalue=0;
  double dvalue=4.0;
  bool sbool=false;
  void method_1(txt){
    setState(() {
      ptext=txt;
    });
  }
  void method(txt){
    setState(() {
      rvalue=txt;
    });
  }
  void method3(txt){
    setState(() {
      dvalue=txt;
    });
  }
  void method4(txt){
    setState(() {
      sbool=txt;
    });
  }
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'My appliction',
      home: new Scaffold(
        appBar: new AppBar(
          title: new Text('My Text'),
          backgroundColor: Colors.teal,
        ),
        body: new Column(
          children: <Widget>[
            new TextField(
              onSubmitted: (String txt){
                setState(() {
                  ptext=txt;
                });
              },
              decoration:new InputDecoration(hintText: 'type',labelText: 'Full Name'),
            ),
            new Text(ptext),
            new RaisedButton(onPressed: (){
              method_1('this is Text');
            }, child: new Text('Submit')),
            new FlatButton(onPressed: null, child: new Text('Submit')),
            new Checkbox(value: true, onChanged: (bool cb){
               setState(){
                 cbool=cb;
                 print(cb);
               }
            }),
             new Radio(value: 2, groupValue: rvalue, onChanged: (int val){
               setState(() {
                 rvalue=val;
                 print(val);

               });
             }),
            new Radio(value: 1, groupValue: rvalue, onChanged: (int val){
               setState(() {
                 rvalue=val;
                 print(val);

               });
             }),
            new Radio(value: 3, groupValue: rvalue, onChanged: (int val){
               setState(() {
                 rvalue=val;
                 print(val);

               });
             }),
        new Slider(value: dvalue,
            min: 1.0,
            max: 20.0,
            onChanged: (double dval){
               setState(() {
                 method3(dval);
               });
            }),
           new Text('this $dvalue'),
           new Switch(value: sbool, onChanged: (bool cb){
             setState(() {
               print(cb);
               method4(cb);
             });
           }),
        //    new RaisedButton.icon(onPressed: null, label: null, icon: ,),
          ],
        ),
      ),
    );
  }
}
