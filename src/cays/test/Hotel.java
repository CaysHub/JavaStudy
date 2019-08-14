package cays.test;

import java.util.Scanner;

public class Hotel {
	/*
	 * 1,2层为标准，3,4 层为双人 ， 5层为豪华
	 */

	Room[][] rooms ;



	Hotel(int rows,int cols){
		rooms = new Room[rows][cols];
		for( int i = 0 ; i < rows ; i++) {
			for ( int j = 0 ; j < cols ; j++) {
				Room room = new Room();
				rooms[i][j] = room;
				System.out.println("rooms " + rooms[i][j].hashCode());
				System.out.println("room " + room.hashCode());
				rooms[i][j].no = i+1 + "-" + (j+1) ;
				rooms[i][j].isUse = false ;
				if(i<=1) {
					rooms[i][j].type = "标准房";
				}else if(i<=3) {
					rooms[i][j].type = "双人房";
				}else {
					rooms[i][j].type = "豪华房";
				}
			}
		}
	}

	//查看房间
	public void watch() {
		System.out.println("true 表示 占用，false 表示空闲");
		for(int i = 0 ; i < rooms.length ; i++) {
			for(int j = 0 ; j < rooms[i].length ; j ++ ) {
				System.out.print(rooms[i][j].no +"/"+rooms[i][j].type + "(" + rooms[i][j].isUse +")  ");
			}
			System.out.println();

		}
	}

	//预定房间
	public void book( String no ) {
		Scanner s = new Scanner(System.in);

		String userinput = s.next();
	}

	//退房
	public void cancel( ) {

	}

}
