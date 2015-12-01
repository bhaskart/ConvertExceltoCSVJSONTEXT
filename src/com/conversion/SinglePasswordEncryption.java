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

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SinglePasswordEncryption {
	private static SinglePasswordEncryption instance = new SinglePasswordEncryption();
	private static boolean initialised = false;
	private static int algorithmID = 0;
	private static int migratedAlgorithmID = 5;
	private static final String[] algorithm = { "plain", "MD5", "SHA-1", "SHA-256", "SHA-384", "SHA-512" };
	public String plaintext = "6gtyjmcpk>2kwzbrdjoc";

	@Test
	public void encrypt() throws Exception {
		algorithmID = 1;

		int algID = algorithmID;

		if (algID == 0) {

		}

		if (algID >= algorithm.length) {
			System.out.println("Invalid Algorithm ID");
		}

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(algorithm[algID]);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("No Such Algorithm");
		}

		try {
			md.update(plaintext.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new Exception(e.getMessage());
		}

		byte raw[] = md.digest();
		System.out.println("After digest:" + md.digest().toString());
		String hash = (new BASE64Encoder()).encode(raw);
		System.out.println("Password:" + plaintext);
		System.out.println("HASH:" + hash);
	}
}
