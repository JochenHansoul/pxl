﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace OefTableView
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class ButtonStyles : ResourceDictionary //omgezet van ContentPage naar dit en ook dit in xaml veranderd
    {
        public ButtonStyles()
        {
            InitializeComponent();
        }
    }
}