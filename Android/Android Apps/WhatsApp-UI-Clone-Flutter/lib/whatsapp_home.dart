import 'package:flutter/material.dart';
import 'package:whatsapp_ui/pages/calls_screen.dart';
import 'package:whatsapp_ui/pages/camera_screen.dart';
import 'package:whatsapp_ui/pages/chats_screen.dart';
import 'package:whatsapp_ui/pages/status_screen.dart';


class WhatsAppHome extends StatefulWidget {
  var cameras;
  WhatsAppHome(this.cameras);
  @override
  _WhatsAppHomeState createState() => new _WhatsAppHomeState();
}

class _WhatsAppHomeState extends State<WhatsAppHome> with SingleTickerProviderStateMixin {
  bool camera_screen = false;
  TabController _tabController;
  Icon icon = new Icon(Icons.message, color: Colors.white,);
  final GlobalKey<ScaffoldState> _scaffoldstate = new GlobalKey<ScaffoldState>();

  void showBar() {
    _scaffoldstate.currentState.showSnackBar(new SnackBar(
        content: new Text(
            'Functionality yet to be implemented')));
  }

  @override
  void initState() {
    super.initState();
    _tabController = new TabController(length: 4, vsync: this, initialIndex: 1);
    _tabController.addListener((){
      setState(() {
        switch(_tabController.index){
          case 0:
            camera_screen = true;
            icon = Icon(Icons.message, color: Colors.white,);
            break;
          case 1:
            camera_screen = false;
            icon = Icon(Icons.message, color: Colors.white,);
            break;
          case 2:
            camera_screen = false;
            icon = Icon(Icons.camera_enhance, color: Colors.white,);
            break;
          case 3:
            camera_screen = false;
            icon = Icon(Icons.call, color: Colors.white,);
            break;
        }
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      key: _scaffoldstate,
      appBar: new AppBar(
        title: new Text('WhatsApp'),
        elevation: 0.7,
        bottom: new TabBar(
          controller: _tabController,
          indicatorColor: Colors.white,
          tabs: <Widget>[
            new Tab(icon: new Icon(Icons.camera_alt)) ,
            new Tab(text: 'CHATS'),
            new Tab(text: 'STATUS'),
            new Tab(text: 'CALLS'),
          ],
        ),
        actions: <Widget>[
          new Icon(Icons.search),
          new Padding(padding: new EdgeInsets.all(10.0)),
          new Icon(Icons.more_vert),
          new Padding(padding: new EdgeInsets.all(5.0)),
        ],
      ),
      body: new TabBarView(
        controller: _tabController,
        children: <Widget>[
          new CameraScreen(widget.cameras),
          new ChatsScreen(),
          new StatusScreen(),
          new CallsScreen(),
        ],
      ),
      floatingActionButton: new FloatingActionButton(
        onPressed: showBar,
        backgroundColor: Theme.of(context).accentColor,
        child: icon,
      ),
    );
  }
}
