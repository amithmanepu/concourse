/*
 * This project is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This project is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this project. If not, see <http://www.gnu.org/licenses/>.
 */
package com.cinchapi.concourse.db;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.cinchapi.concourse.store.api.Queryable.SelectOperator;
import com.cinchapi.concourse.store.temp.CommitLog;
import com.cinchapi.concourse.store.temp.HeapDatabase;

/**
 * 
 * 
 * @author jnelson
 */
public class Test {
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		HeapDatabase log = HeapDatabase.newInstancewithExpectedSize(3);
		log.add(1, "name", 10);
		log.add(2, "name", 20);
		log.add(3, "name", "30");
		log.remove(2, "name", 20);
		System.out.println(log.select("name", SelectOperator.EQUALS, "30"));
//		log.add(1, "row", false);
	}

}