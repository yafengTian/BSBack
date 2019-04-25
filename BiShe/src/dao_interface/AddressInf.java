package dao_interface;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.Address;

public interface AddressInf {
	/*
	 * ����û����ջ���ַ
	 * */
	public int addAddress(@Param("username")String username,@Param("phonenumber")String phonenumber,
			@Param("openid")String openid,@Param("moren")int moren,@Param("area")String area,@Param("address")String address);
	
	/*
	 * ��ʾ�û����ջ���ַ
	 * */
	public List<Address> showAddress(String openid);
}
