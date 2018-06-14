/*
 * Copyright (C) 2018 Kurumin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author Kurumin
 */
public class RawFileReader {
    
    protected String filename;
    
    public RawFileReader(String _filename){
        this.filename = _filename;
    }
    
    protected String readRawString(){
        String jsonString = new String();
        FileReader fr = null;
        BufferedReader br = null;
        System.out.println("Reading \""+filename+"\"");
        try {
            File file = new File(filename);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = new String();
            try {
                do{
                    line = br.readLine();
                    if(line != null){
                        jsonString += line;
                    }
                } while(line != null);
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName(), ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(getClass().getName(), ex.getMessage());
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName(), ex.getMessage());
            }
        }
        return jsonString;
    }
}
