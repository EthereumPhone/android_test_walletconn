package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import dev.pinkroom.walletconnectkit.WalletConnectButton
import dev.pinkroom.walletconnectkit.WalletConnectKit
import dev.pinkroom.walletconnectkit.WalletConnectKitConfig

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfIconUrlStrings = listOf<String>()
        val config = WalletConnectKitConfig(
            context = this,
            relayUrl = "wss://bridge.aktionariat.com:8887",
            appUrl = "walletconnectkit.com",
            appName = "WalletConnectKit",
            appDescription = "WalletConnectKit is the Swiss Army toolkit for WalletConnect!"
        )

        val walletConnectKit = WalletConnectKit.Builder(config).build()
        val walletConnectButton: WalletConnectButton =  findViewById(R.id.bttnWalletConnect)

        walletConnectButton.start(walletConnectKit) { address ->
            println("You are connected with account: $address")
        }


    }
}