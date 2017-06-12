package repositories;

import java.util.ArrayList;
import java.util.List;

import domain.UserInformation;

public class UserList
	implements UserInformationRepository {
	
	private static List<UserInformation> userDB
			= new ArrayList<UserInformation>();
	
	@Override
	public UserInformation getUserByUsername(String username) {
		for (UserInformation userInfo: userDB) {
			if (userInfo.getUsername().equalsIgnoreCase(username))
				return userInfo;
		}
		return null;
	}
	
	@Override
	public void addUserToList(UserInformation userInfo) {
		userDB.add(userInfo);
	}	
	
	@Override
	public UserInformation createAdmin() {
		UserInformation admin = new UserInformation();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setEmail("admin@domain.com");
		admin.setPermission("admin");
		
		return admin;
	}
	public UserInformation getUserInfo(int index) {
		return userDB.get(index);
	}
	public int getListSize() {
		return userDB.size();
	}
}
