import 'package:flutter/material.dart';

void main() => runApp(new MaterialApp(
      home: MyApp(),
    ));

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String img =
      "https://helpx.adobe.com/in/stock/how-to/visual-reverse-image-search/_jcr_content/main-pars/image.img.jpg/visual-reverse-image-search-v2_1000x560.jpg";
  String img1 = "https://www.gettyimages.pt/gi-resources/images/Homepage/Hero/PT/PT_hero_42_153645159.jpg";
  String img2 =
      "https://d11w1qd0fx2gm0.cloudfront.net/demo/sites/41/unicorn-wallpaper1.jpg";
  String img3 =
      "https://www.elastic.co/assets/bltada7771f270d08f6/enhanced-buzz-1492-1379411828-15.jpg";
  String img4 =
      "https://cdn.photographylife.com/wp-content/uploads/2014/06/Nikon-D810-Image-Sample-4-960x640.jpg";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: CustomScrollView(
        reverse: true,
        slivers: <Widget>[
          SliverItem(img:img),
          SliverItem(img:img1),
          SliverItem(img:img2),
          SliverItem(img:img3),
          SliverItem(img:img4),
          SliverFillRemaining(
            child: Container(
              color: Colors.red,
            ),
          )
          /*  SliverFixedExtentList(
            itemExtent: 250.0,
            delegate: SliverChildListDelegate([
              Card(color:Colors.red,),
              Card(color:Colors.red,),
              Card(color:Colors.red,),
              Card(color:Colors.red,),
              Card(color:Colors.red,),
              Card(color:Colors.red,),
              Card(color:Colors.red,),
              Card(color:Colors.red,),
              Card(color:Colors.red,),
              Card(color:Colors.red,),
              Card(color:Colors.red,),
              Card(color:Colors.red,),
              Card(color:Colors.red,),
            ]),
          )*/
        ],
      ),
    );
  }
}
class SliverItem extends StatelessWidget {
  final String img;

  const SliverItem({Key key, this.img}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return SliverAppBar(
      pinned: true,
      expandedHeight: 300.0,
      flexibleSpace: FlexibleSpaceBar(
        title: new Text("Data"),
        centerTitle: true,
        background: Image.network(
          img,
          fit: BoxFit.cover,
        ),
      ),
    );
  }
}

