package com.Wolf_IV.MiniJeu.HikaBrain;

import com.Wolf_IV.MiniJeu.Command.CStart;
import com.Wolf_IV.MiniJeu.Team.TeamC;

public class MatchMaking {
	public static int maxMatch=0;
	public static int mAtT=0;
	static int[] team1e1 =new int[20];
	static int[] team2e1 =new int[20];
	static int[] team1e2 =new int[20];
	static int[] team2e2 =new int[20];
	static int[] team1e3 =new int[20];
	static int[] team2e3 =new int[20];
	static int[] team1e4 =new int[20];
	static int[] team2e4 =new int[20];
	public static int[] t1 =new int[10];
	public static int[] t2 =new int[10];
	
	public static void match(int m) {
		if(m<=maxMatch) {
			if(mAtT>=1) {
				t1[1] = team1e1[m];
				t2[1] = team2e1[m];
			}
			if(mAtT>=2) {
				t1[2] = team1e2[m];
				t2[2] = team2e2[m];
			}
			if(mAtT>=3) {
				t1[3] = team1e3[m];
				t2[3] = team2e3[m];
			}
			if(mAtT>=4) {
				t1[4] = team1e4[m];
				t2[4] = team2e4[m];
			}
		}
	}
	
		public static void init() {
			if(CStart.nubTeamC == 2) {
				maxMatch = 1;
				mAtT=1;
				team1e1[0] = 1;
				team2e1[0] = 2;
			}else if(CStart.nubTeamC == 3) {
				maxMatch = 3;
				mAtT=1;
				team1e1 = new int[]{1,1,2};
				team2e1 = new int[]{2,3,3};
			}else if(CStart.nubTeamC == 4) {
				maxMatch = 3;
				mAtT=2;
				team1e1 = new int[]{1,1,1};
				team2e1 = new int[]{2,4,3};
				team1e2 = new int[]{3,2,2};
				team2e2 = new int[]{4,3,4};
			}else if(CStart.nubTeamC == 5) {
				maxMatch = 5;
				mAtT=2;
				team1e1 = new int[]{1,1,1,1,3};
				team2e1 = new int[]{2,3,4,5,5};
				team1e2 = new int[]{3,4,2,2,2};
				team2e2 = new int[]{4,5,5,3,4};
			}else if(CStart.nubTeamC == 6) {
				maxMatch = 5;
				mAtT=3;
				team1e1 = new int[]{1,1,1,1,1};
				team2e1 = new int[]{2,3,4,5,6};
				team1e2 = new int[]{3,4,2,2,2};
				team2e2 = new int[]{4,5,5,3,4};
				team1e3 = new int[]{5,2,3,4,3};
				team2e3 = new int[]{6,6,6,6,5};
			}else if(CStart.nubTeamC == 7) {
				maxMatch = 7;
				mAtT=3;
				team1e1 = new int[]{1,1,1,1,1,1,4};
				team2e1 = new int[]{2,3,4,5,6,7,7};
				team1e2 = new int[]{3,6,2,2,2,2,2};
				team2e2 = new int[]{4,7,3,7,4,5,6};
				team1e3 = new int[]{5,4,5,3,3,4,3};
				team2e3 = new int[]{6,5,7,6,7,6,5};
			}else if(CStart.nubTeamC == 8) {
				maxMatch = 7;
				mAtT=4;
				team1e1 = new int[]{1,1,1,1,1,1,1};
				team2e1 = new int[]{2,3,4,5,6,7,8};
				team1e2 = new int[]{3,2,2,2,2,2,2};
				team2e2 = new int[]{4,8,3,7,4,5,6};
				team1e3 = new int[]{5,4,5,3,3,3,3};
				team2e3 = new int[]{6,5,7,6,7,8,5};
				team1e4 = new int[]{7,6,6,4,5,4,4};
				team2e4 = new int[]{8,7,8,8,8,6,7};
			}
			
		}
}
