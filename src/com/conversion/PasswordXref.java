// Copyright (c) 2015 Bhaskar Thadisetty. All rights reserved.
// https://github.com/bhaskart/ConvertExceltoCSVJSONTEXT/
// The MIT License (MIT)
//
// Copyright (c) 2001-2015 Bhaskar Thadisetty
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.
package com.conversion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PasswordXref {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filePath = "C://xref/password_plain.csv";
		String newFilePath = "C://xref/passwordXref.txt";
		ArrayList<String> data = null;
		try {
			File f = new File(filePath);
			File f1 = new File(newFilePath);
			FileReader fr = new FileReader(f);
			FileWriter fw = new FileWriter(f1);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			StringTokenizer st;
			StringBuilder sw = null;
			int count = 1;
			while ((line = br.readLine()) != null) {
				st = new StringTokenizer(line, "|");
				data = new ArrayList<String>();
				while (st.hasMoreTokens()) {
					data.add(st.nextToken());
				}
				String encryptPassword = PasswordEncryption.encrypt(data.get(2));
				sw = new StringBuilder();
				sw.append((data.get(0)));
				sw.append("|");
				sw.append((data.get(1)));
				sw.append("|");
				sw.append((data.get(2)));
				sw.append("|");
				sw.append(encryptPassword);

				System.out.println("Writing Line" + count + ":" + sw.toString() + " into file");
				fw.write(sw.toString());
				fw.write(System.getProperty("line.separator"));
				count++;
			}
			System.out.println("File creation done...");
			System.out.println("total accounts:" + (count - 1));
			fw.close();
			fr.close();
		} catch (Exception ex) {
		}
	}
}
