String url4e = "http://w1.weather.gov/xml/current_obs/CWAV.xml";
		URL url1 = new URL(url4e);
		HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		System.out.println();

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String inputLine;
		// int count = 0;

		while ((inputLine = in.readLine()) != null) {
			// count++;
			// System.out.println(count);
			System.out.println(inputLine);
		}

		in.close();
    
    
    
    
    
    
    // InetAddress address = InetAddress.getByName(www.weather.gov);
		// client = new Socket(address, 80);
		// PrintWriter out = new PrintWriter(new BufferedWriter(new
		// OutputStreamWriter(client.getOutputStream())));
		// out.println("GET /xml/current_obs/CWAV.xml HTTP/1.0");
		// out.println();
		// out.flush();
		//
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(client.getInputStream()));
		//
		// String inputLine;
		// //int count = 0;
		//
		// while ((inputLine = in.readLine()) != null) {
		// //count++;
		// //System.out.println(count);
		// System.out.println(inputLine);
		// }
		//
		// in.close();
		// System.out.println("PRINTING HERE!!!");


//http://w1.weather.gov/xml/current_obs/index.xml
//http://w1.weather.gov/xml/current_obs/CWAV.xml

http://stackoverflow.com/questions/32979124/jsoup-exception-invalid-url
