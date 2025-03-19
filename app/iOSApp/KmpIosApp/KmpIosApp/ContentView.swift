//
//  ContentView.swift
//  KmpIosApp
//
//  Created by Dhiman Ranjit on 19/03/25.
//

import SwiftUI
import KmpApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        return SampleKmpViewControllerKt.SampleKmpViewController()
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        
    }
}


struct ContentView: View {
    var body: some View {
        ComposeView()
    }
}

#Preview {
    ContentView()
}
