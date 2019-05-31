package com.dodo.project.base.commons.utils.ip;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

/*
 * <b>IpHelper</b></br>
 *
 * <pre>
 * ip相关操作辅助类
 * </pre>
 *
 * @Author xqyjjq walk_code@163.com
 * @Date 2019/5/30 19:22
 * @Since JDK 1.8
 */
public class IpHelper {
	private static final Logger log = Logger.getLogger("IpHelper");

	// 系统的本地IP地址
	public static String LOCAL_IP;

	// 系统的本地服务器名称
	public static String HOST_NAME;

	static {
		String ip = "";
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			HOST_NAME = inetAddress.getHostName();
			byte[] addr = inetAddress.getAddress();
			for (int i = 0; i < addr.length; i++) {
				if (i > 0) {
					ip += ".";
				}
				ip += addr[i] & 0xFF; // 补码
			}
		} catch (UnknownHostException e) {
			ip = "unknown";
			log.severe(e.getMessage());
		} finally {
			LOCAL_IP = ip;
		}
	}

	/*
	 * @Description: 根据X-Forwarded-For获取起始的ip地址
	 * 如果一个请求经过了多个代理服务器，那么每一个代理服务器的IP地址都会被依次记录在内。
	 * 也就是说，最右端的IP地址表示最近通过的代理服务器，而最左端的IP地址表示最初发起请求的客户端的IP地址。
	 * 例如：X-Forwarded-For：192.168.1.110, 192.168.1.120,
	 * 192.168.1.130, 192.168.1.100 用户真实IP为： 192.168.1.110
	 * @Author: walk_code walk_code@163.com
	 * @Param:
	 * @return:
	 * @Date: 2019/5/31 10:01
	 */
	public String getIpAddress(HttpServletRequest httpServletRequest) {
		String ip = httpServletRequest.getHeader("X-Forwarded-For");
		if (null == ip || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = httpServletRequest.getHeader("Proxy-Client-IP");
		}

		if (null == ip || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = httpServletRequest.getHeader("WL-Proxy-Client-IP");
		}

		if (null == ip || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = httpServletRequest.getRemoteAddr();
			if (ip.equals("127.0.0.1")) {
				/*根据网卡获取本机配置的IP*/
				try {
					byte[] addr = InetAddress.getLocalHost().getAddress();
					ip = new String(addr);
				} catch (UnknownHostException e) {
					log.severe("IpHelper error." + e.getMessage());
				}
			}
		}

		/**
		 * 对于通过多个代理的情况， 第一个IP为客户端真实IP,多个IP按照','分割 "***.***.***.***".length() =
		 * 15
		 */
		if (ip != null && ip.length() > 15) {
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}

		return ip;
	}

	/*
	 * @Description: 判断是否为本地IP
	 * @Author: walk_code walk_code@163.com
	 * @Param: []
	 * @return: boolean
	 * @Date: 2019/5/31 10:43
	 */
	public static boolean isLocalIp(String ip) {
		if (StringUtils.isNoneBlank(ip)) {
			try {
				InetAddress   localHost = InetAddress.getLocalHost();
				InetAddress[] inetAs    = InetAddress.getAllByName(localHost.getHostName());
				for (InetAddress inetAddress : inetAs) {
					if (ip.equals(inetAddress.getHostAddress())) {
						return true;
					}
				}
			} catch (UnknownHostException e) {
				log.severe("IpHelper error." + e.getMessage());
			}
		}

		return false;
	}
}
