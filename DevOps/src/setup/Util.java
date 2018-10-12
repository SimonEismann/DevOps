package setup;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Util {
	
	public static String getUrlContent(String urlin) {
		URL url;
		String body = "";
		try {
			url = new URL(urlin);
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();  // ** WRONG: should use "con.getContentType()" instead but it returns something like "text/html; charset=UTF-8" so this value must be parsed to extract the actual encoding
		encoding = encoding == null ? "UTF-8" : encoding;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[8192];
		int len = 0;
		while ((len = in.read(buf)) != -1) {
		    baos.write(buf, 0, len);
		}
		body = new String(baos.toByteArray(), encoding);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return body;
	}
	
	public static void sendCommandBackground(String host, String command) {
		String user = "seadmin";
		String password = "descartes";
		try {
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, 22);
			session.setPassword(password);
			session.setConfig(config);
			session.connect();

			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			channel.setInputStream(null);

			channel.connect();
			Thread.sleep(500);
			System.out.println("\t" + command + " @ " + host + " BACKGROUND");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendCloudShellCommand(String host, String command) {
		String user = "seadmin";
		String password = "descartes";
		try {
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, 22);
			session.setPassword(password);
			session.setConfig(config);
			session.connect();

			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			channel.setInputStream(null);

			channel.connect();
			while (true) {
				if (channel.isClosed()) {
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();
			session.disconnect();
			System.out.println("\t" + command + " @ " + host + " DONE");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendCommand(String host, String command) {
		String user = "seadmin";
		String password = "descartes";
		try {
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, 22);
			session.setPassword(password);
			session.setConfig(config);
			session.connect();

			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			channel.setInputStream(null);

			channel.connect();
			while (true) {
				if (channel.isClosed()) {
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();
			session.disconnect();
			System.out.println("\t" + command + " @ " + host + " DONE");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendCommandWithLogs(String host, String command) {
		String user = "seadmin";
		String password = "descartes";
		try {
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, 22);
			session.setPassword(password);
			session.setConfig(config);
			session.connect();

			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();
			channel.connect();
			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					System.out.print("\t\t" + new String(tmp, 0, i));
				}
				if (channel.isClosed()) {
					System.out.println("\t\t" + "exit-status: " + channel.getExitStatus());
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();
			session.disconnect();
			System.out.println("\t" + command + " @ " + host + " DONE");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String sendCommandWithReturnAndLogs(String host, String command) {
		String user = "seadmin";
		String password = "descartes";
		try {
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, 22);
			session.setPassword(password);
			session.setConfig(config);
			session.connect();

			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();
			channel.connect();
			byte[] tmp = new byte[1024];
			String out = "";
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					out += new String(tmp, 0, i);
					System.out.print("\t\t" + new String(tmp, 0, i));
				}
				if (channel.isClosed()) {
					System.out.println("\t\t" + "exit-status: " + channel.getExitStatus());
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();
			session.disconnect();
			System.out.println("\t" + command + " @ " + host + " DONE");
			return out;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public static String sendCommandWithReturn(String host, String command) {
		String user = "seadmin";
		String password = "descartes";
		try {
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, 22);
			session.setPassword(password);
			session.setConfig(config);
			session.connect();

			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();
			channel.connect();
			byte[] tmp = new byte[1024];
			String out = "";
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					out += new String(tmp, 0, i);
				}
				if (channel.isClosed()) {
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();
			session.disconnect();
			System.out.println("\t" + command + " @ " + host + " DONE");
			return out;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public static void getFile(String host, String filename) {
		FileOutputStream fos = null;
		try {

			JSch jsch = new JSch();
			Session session = jsch.getSession("seadmin", host, 22);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setPassword("descartes");
			session.setConfig(config);
			session.connect();

			// exec 'scp -f rfile' remotely
			String command = "scp -f " + filename;
			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);

			// get I/O streams for remote scp
			OutputStream out = channel.getOutputStream();
			InputStream in = channel.getInputStream();

			channel.connect();

			byte[] buf = new byte[1024];

			// send '\0'
			buf[0] = 0;
			out.write(buf, 0, 1);
			out.flush();

			while (true) {
				int c = checkAck(in);
				if (c != 'C') {
					break;
				}

				// read '0644 '
				in.read(buf, 0, 5);

				long filesize = 0L;
				while (true) {
					if (in.read(buf, 0, 1) < 0) {
						// error
						break;
					}
					if (buf[0] == ' ')
						break;
					filesize = filesize * 10L + (long) (buf[0] - '0');
				}

				String file = null;
				for (int i = 0;; i++) {
					in.read(buf, i, 1);
					if (buf[i] == (byte) 0x0a) {
						file = new String(buf, 0, i);
						break;
					}
				}

				// System.out.println("filesize="+filesize+", file="+file);

				// send '\0'
				buf[0] = 0;
				out.write(buf, 0, 1);
				out.flush();

				// read a content of lfile
				fos = new FileOutputStream(file);
				int foo;
				while (true) {
					if (buf.length < filesize)
						foo = buf.length;
					else
						foo = (int) filesize;
					foo = in.read(buf, 0, foo);
					if (foo < 0) {
						// error
						break;
					}
					fos.write(buf, 0, foo);
					filesize -= foo;
					if (filesize == 0L)
						break;
				}
				fos.close();
				fos = null;

				if (checkAck(in) != 0) {
					System.exit(0);
				}

				// send '\0'
				buf[0] = 0;
				out.write(buf, 0, 1);
				out.flush();
			}

			session.disconnect();
		} catch (Exception e) {
			System.out.println(e);
			try {
				if (fos != null)
					fos.close();
			} catch (Exception ee) {
			}
		}
	}
	
	  public static void putFile(String host, String fileName){
		    FileInputStream fis=null;
		    try{

			JSch jsch = new JSch();
			Session session = jsch.getSession("seadmin", host, 22);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setPassword("descartes");
			session.setConfig(config);
			session.connect();

		      boolean ptimestamp = false;

		      File _lfile = new File(fileName);
		      // exec 'scp -t rfile' remotely
		      String command="scp " + (ptimestamp ? "-p" :"") +" -t " + _lfile.getName();
		      Channel channel=session.openChannel("exec");
		      ((ChannelExec)channel).setCommand(command);

		      // get I/O streams for remote scp
		      OutputStream out=channel.getOutputStream();
		      InputStream in=channel.getInputStream();

		      channel.connect();

		      if(checkAck(in)!=0){
			System.exit(0);
		      }


		      if(ptimestamp){
		        command="T "+(_lfile.lastModified()/1000)+" 0";
		        // The access time should be sent here,
		        // but it is not accessible with JavaAPI ;-<
		        command+=(" "+(_lfile.lastModified()/1000)+" 0\n"); 
		        out.write(command.getBytes()); out.flush();
		        if(checkAck(in)!=0){
		  	  System.exit(0);
		        }
		      }

		      // send "C0644 filesize filename", where filename should not include '/'
		      long filesize=_lfile.length();
		      command="C0644 "+filesize+" ";
		      command+=_lfile.getName();
		      command+="\n";
		      out.write(command.getBytes()); out.flush();
		      if(checkAck(in)!=0){
			System.exit(0);
		      }

		      // send a content of lfile
		      fis=new FileInputStream(fileName);
		      byte[] buf=new byte[1024];
		      while(true){
		        int len=fis.read(buf, 0, buf.length);
			if(len<=0) break;
		        out.write(buf, 0, len); //out.flush();
		      }
		      fis.close();
		      fis=null;
		      // send '\0'
		      buf[0]=0; out.write(buf, 0, 1); out.flush();
		      if(checkAck(in)!=0){
			System.exit(0);
		      }
		      out.close();

		      channel.disconnect();
		      session.disconnect();

		    }
		    catch(Exception e){
		      System.out.println(e);
		      try{if(fis!=null)fis.close();}catch(Exception ee){}
		    }
		  }

	static int checkAck(InputStream in) throws IOException {
		int b = in.read();
		if (b == 0)
			return b;
		if (b == -1)
			return b;

		if (b == 1 || b == 2) {
			StringBuffer sb = new StringBuffer();
			int c;
			do {
				c = in.read();
				sb.append((char) c);
			} while (c != '\n');
			if (b == 1) { // error
				System.out.print(sb.toString());
			}
			if (b == 2) { // fatal error
				System.out.print(sb.toString());
			}
		}
		return b;
	}
}
