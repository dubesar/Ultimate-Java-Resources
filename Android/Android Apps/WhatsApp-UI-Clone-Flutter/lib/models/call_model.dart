import 'package:flutter/material.dart';

class CallModel {
  final String name;
  final String message;
  final String avatarUrl;
  final String call_detail;
  final String type_call;

  CallModel(this.name, this.message, this.avatarUrl, this.call_detail,
      this.type_call);


}

List<CallModel> dummy_data = [
  new CallModel('Mom', 'Today, 17:48', 'https://scontent-bom1-2.xx.fbcdn.net/v/t1.0-9/40178277_2235777386450862_5740800171420155904_n.jpg?_nc_cat=101&_nc_ht=scontent-bom1-2.xx&oh=a08778e15ed99f84af9296c10e2e68fc&oe=5CA3354D','images/sent.png' ,'images/call.png'),
  new CallModel('Sona', 'Today, 16:40', 'https://scontent-bom1-2.xx.fbcdn.net/v/t1.0-9/37228649_1955324291185109_7147450451040927744_n.jpg?_nc_cat=108&_nc_ht=scontent-bom1-2.xx&oh=28d0f35cfb9de021dbda42bb4601bba3&oe=5C914CF6', 'images/sent.png', 'images/video.png'),
  new CallModel('Dad', 'Today, 15:01', 'https://scontent-bom1-2.xx.fbcdn.net/v/t1.0-9/37228649_1955324291185109_7147450451040927744_n.jpg?_nc_cat=108&_nc_ht=scontent-bom1-2.xx&oh=28d0f35cfb9de021dbda42bb4601bba3&oe=5C914CF6', 'images/missed.png' , 'images/call.png'),
  new CallModel('Rajat', 'Yesterday, 20:08', 'https://scontent-bom1-2.xx.fbcdn.net/v/t31.0-8/22383997_117247289030443_6169130777245229885_o.jpg?_nc_cat=104&_nc_ht=scontent-bom1-2.xx&oh=8b8a8b20931552811afccd3b075f983c&oe=5CA26B85', 'images/missed.png' , 'images/video.png'),
  new CallModel('Rishabh', 'Yesterday, 19:26 ', 'https://scontent-bom1-2.xx.fbcdn.net/v/t1.0-9/23244392_1404194179698330_6488769490789864763_n.jpg?_nc_cat=101&_nc_ht=scontent-bom1-2.xx&oh=7fcec8969813e7698f471943fac33c8c&oe=5C98A69C','images/sent.png' , 'images/call.png'),
  new CallModel('Divyam', 'Yesterday, 10:02', 'https://scontent-bom1-2.xx.fbcdn.net/v/t1.0-9/45752096_369084937161767_4226458569014247424_n.jpg?_nc_cat=111&_nc_ht=scontent-bom1-2.xx&oh=e67592aa1bfbf94114ddef54ac3e05c6&oe=5C8C7157', 'images/missed.png' , 'images/video.png'),
];
