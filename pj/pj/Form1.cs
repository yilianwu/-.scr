using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Runtime.InteropServices;
using System.Diagnostics;

namespace pj
{
    public partial class Form1 : Form
    {
        float x;
        float y;
        float x1;
        float y1;
        int time = 0;
        int time1 = 0;
        bool openpj = false;
        public Form1()
        {
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.WindowState = FormWindowState.Maximized;
            this.TopMost = true;
            this.Opacity = 0.01;
            this.ShowInTaskbar = false;
            InitializeComponent();
        }
        /*[DllImport("user32.dll", SetLastError = true)]
        static extern IntPtr FindWindow(string lpClassName, string lpWindowName);

        [DllImport("user32.dll")]
        public static extern int GetWindowRect(IntPtr hWnd, out RECT lpRect);
        [StructLayout(LayoutKind.Sequential)]
        public struct RECT
        {
            public int left;
            public int top;
            public int right;
            public int bottom;
        }*/


        public void mousepos()
        {
            this.Cursor = new Cursor(Cursor.Current.Handle);
            x = Cursor.Position.X;
            y = Cursor.Position.Y;
            

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if (openpj == false)
            {
                if (TopMost == true)
                {
                    time++;
                    this.timer2.Stop();
                    if (time == 15)
                    {
                        this.timer1.Stop();
                        time = 0;
                        ProcessStartInfo open = new ProcessStartInfo();
                        open.FileName = "bouncyloadingbar3.exe";
                        open.WorkingDirectory = @"Y:\Documents\Processing\bouncyloadingbar3\application.windows64";
                        Process.Start(open);
                        openpj = true;
                        this.TopMost = false;
                        this.timer2.Stop();
                    }

                }
            }
           
            
        }

        private void Form1_MouseMove(object sender, MouseEventArgs e)
        {
            mousepos();
            if (this.TopMost==true)
            {
                System.Threading.Thread.Sleep(1000);
                if (Cursor.Position.X == x && Cursor.Position.Y == y)
                {
                    x1 = x;
                    y1 = y;
                    this.timer1.Start();
                }
            }
            if (this.TopMost == false)
            {
                System.Threading.Thread.Sleep(90);
                if (x1 != Cursor.Position.X || y1 != Cursor.Position.Y)
                {
                    
                    this.timer2.Start();

                }

                openpj = false;
            }


        }

        private void timer2_Tick(object sender, EventArgs e)
        {
            if (this.TopMost==false)
            {
                time1++;
                if (time1 == 1)
                {
                    this.timer2.Stop();
                    time1 = 0;
                    //MessageBox.Show("Time's up!");
                    System.Threading.Thread.Sleep(1000);
                    this.TopMost = true;
                    
                }
            }
            

        }

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Escape)
            {
                Application.Exit();
            }
        }
    }
}
