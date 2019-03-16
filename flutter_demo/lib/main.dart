
import 'package:flutter/material.dart';

const String _AccountName = 'Aravind Vemula';
const String _AccountEmail = 'vemula.aravind336@gmail.com';
const String _AccountAbbr = 'AV';

void main() => runApp(new Keeper());

class Keeper extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
        title: 'Keeper',
        theme: new ThemeData(
            primaryColor: Colors.purple
        ),
        home: new KeeperDrawer(),
        // Routes
        routes: <String, WidgetBuilder> {
          Notes.routeName : (BuildContext context) => new Notes()
        }
    );
  }
}

class KeeperDrawer extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      drawer: new Drawer(
          child: new ListView(
              padding: const EdgeInsets.only(top: 0.0),
              children: <Widget>[
                new UserAccountsDrawerHeader(
                    accountName: const Text(_AccountName),
                    accountEmail: const Text(_AccountEmail),
                    currentAccountPicture: new CircleAvatar(
                        backgroundColor: Colors.brown,
                        child: new Text(_AccountAbbr)
                    ),
                    otherAccountsPictures: <Widget>[
                      new GestureDetector(
                        onTap: () => _onTapOtherAccounts(context),
                        child: new Semantics(
                          label: 'Switch Account',
                          child: new CircleAvatar(
                            backgroundColor: Colors.brown,
                            child: new Text('SA'),
                          ),
                        ),
                      )
                    ]
                ),
                new ListTile(
                  leading: new Icon(Icons.lightbulb_outline),
                  title: new Text('First Pages'),
                  onTap: (){
                    Navigator.push(context, PageTwo()),
                  }
                ),
                new Divider(),
                new ListTile(
                  leading: new Text('Label'),
                  trailing: new Text('Edit'),
                  onTap: () => _onListTileTap(context),
                ),
                new ListTile(
                  leading: new Icon(Icons.label),
                  title: new Text('Expense'),
                  onTap: () => _onListTileTap(context),
                ),
                new ListTile(
                  leading: new Icon(Icons.label),
                  title: new Text('Inspiration'),
                  onTap: () => _onListTileTap(context),
                ),
                new ListTile(
                  leading: new Icon(Icons.label),
                  title: new Text('Personal'),
                  onTap: () => _onListTileTap(context),
                ),
                new ListTile(
                  leading: new Icon(Icons.label),
                  title: new Text('Work'),
                  onTap: () => _onListTileTap(context),
                ),
                new ListTile(
                  leading: new Icon(Icons.add),
                  title: new Text('Create new label'),
                  onTap: () => _onListTileTap(context),
                ),
                new Divider(),
                new ListTile(
                  leading: new Icon(Icons.archive),
                  title: new Text('Archive'),
                  onTap: () => _onListTileTap(context),
                ),
                new ListTile(
                  leading: new Icon(Icons.delete),
                  title: new Text('Trash'),
                  onTap: () => _onListTileTap(context),
                ),
                new Divider(),
                new ListTile(
                  leading: new Icon(Icons.settings),
                  title: new Text('Settings'),
                  onTap: () => _onListTileTap(context),
                ),
                new ListTile(
                  leading: new Icon(Icons.help),
                  title: new Text('Help & feedback'),
                  onTap: () => _onListTileTap(context),
                )
              ]
          )
      ),
        appBar: new AppBar(
    title: new Text('Keeper'),
    ),
    body:new Container(

    )
    );
  }

  _onTapOtherAccounts(BuildContext context) {
    Navigator.of(context).pop();
    showDialog<Null>(
      context: context,
      child: new AlertDialog(
        title: const Text('Account switching not implemented.'),
        actions: <Widget>[
          new FlatButton(
            child: const Text('OK'),
            onPressed: () {
              Navigator.of(context).pop();
            },
          ),
        ],
      ),
    );
  }

  _onListTileTap(BuildContext context) {
    Navigator.of(context).pop();
    showDialog<Null>(
      context: context,
      child: new AlertDialog(
        title: const Text('Not Implemented'),
        actions: <Widget>[
          new FlatButton(
            child: const Text('OK'),
            onPressed: () {
              Navigator.of(context).pop();
            },
          ),
        ],
      ),
    );
  }
}

class PageTwo extends MaterialPageRoute<Null>{
  PageTwo():super(builder:(BuildContext context)){
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('Title'),
      ),
      body: new Center(
        child: new Text(
            'Notes',
            style: new TextStyle(
                fontSize: 24.0
            )
        ),
      ),
    );
  }

}
class Notes extends StatelessWidget {
  static final String routeName = '/notes';

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      drawer: new Drawer(),
      appBar: new AppBar(
        title: new Text('Notes'),
      ),
      body: new Center(
        child: new Text(
            'Notes',
            style: new TextStyle(
                fontSize: 24.0
            )
        ),
      ),
    );
  }
}