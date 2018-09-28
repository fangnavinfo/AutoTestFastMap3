package com.example.fang.autotestfastmap;

import android.os.Environment;
import android.support.test.espresso.core.deps.guava.io.ByteStreams;
import android.util.Log;

import java.io.InputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import static org.junit.Assert.assertFalse;

/**
 * Created by fang on 18/9/21.
 */
public class CPUMonitor
{
    static void Start() throws Exception
    {
        outStream = new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "cpu.txt"));
        endFlag = false;

        thrMonitor = new Thread(new MonitorRunner());
        thrMonitor.start();
    }

    static void End() throws Exception
    {
        infoOverload = "";

        endFlag = true;
        thrMonitor.join();
        outStream.close();
    }

    static void Assert()
    {
        if (infoOverload.length() != 0)
        {
            String temp = infoOverload;
            infoOverload = "";
            assertFalse(temp, true);
        }
    }

    static class MonitorRunner implements Runnable
    {
        public void run()
        {
            try
            {
                while (!endFlag)
                {
                    Runtime runTime = Runtime.getRuntime();
                    Process pRunCmd = runTime.exec("top -d 10 -m 10 -n 1  -t -s cpu");

                    Date date = new Date();
                    SimpleDateFormat sdr = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
                    String strDate = "\n" + sdr.format(date);
                    Log.d("CPUMontor", strDate);
                    outStream.write(strDate.getBytes());

                    InputStream nomalStream = pRunCmd.getInputStream();
                    InputStream errorStream = pRunCmd.getErrorStream();


                    byte[] bytesNormal = new byte[1024];
                    nomalStream.read(bytesNormal);
                    outStream.write(bytesNormal);

                    byte[] bytesError = new byte[1024];
                    errorStream.read(bytesError);
                    outStream.write(bytesError);

                    String normalOutput = new String(bytesNormal,"UTF-8");
                    CheckCPUOverload(normalOutput);
                }
            }
            catch (Exception e)
            {
                Log.e("MonitorRunner", e.getMessage());
            }
        }
    }

    static void CheckCPUOverload(String cmdOutput)
    {
        String[] outputArray = cmdOutput.split("\n");
        for (String outputLine : outputArray)
        {
            if (!outputLine.contains("%"))
            {
                continue;
            }

            String[] itemArray = outputLine.split(" ");
            for (String item : itemArray)
            {
                if (!item.contains("%"))
                {
                    continue;
                }

                String temp = item.substring(0,item.indexOf("%"));
                if(temp.equals("CPU"))
                {
                    break;
                }

                int percent = Integer.parseInt(temp);
                if (outputLine.contains("fastmap") && percent > 10)
                {
                    infoOverload = "CPU OVERLOAD!!! \n" + cmdOutput;
                }
            }
        }
    }


    static String infoOverload = "";

    static Thread thrMonitor;
    static OutputStream outStream;
    static boolean endFlag = false;
}
