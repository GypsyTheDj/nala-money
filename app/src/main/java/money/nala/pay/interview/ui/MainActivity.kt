package money.nala.pay.interview.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import money.nala.pay.interview.R
import money.nala.pay.interview.ui.viewmodels.TransactionViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var transactionModel: TransactionViewModel
    private lateinit var transactionListAdapter: TransactionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transactionModel = ViewModelProvider(this).get(TransactionViewModel::class.java)

        initTransactionListView()

        subscribeToTransactionModel()
    }

    private fun initTransactionListView() {
        transactionListAdapter = TransactionAdapter(mutableListOf(), true)
        transaction_list.adapter = transactionListAdapter
        transaction_list.layoutManager = LinearLayoutManager(this)
    }

    private fun subscribeToTransactionModel() {
        Log.d("MainActivity", "subscribeToTransactionModel()")

        val allTransactions = transactionModel.getAllTransactions()
        Log.d("MainActivity", "allTransactions: ${allTransactions.size}")

        transactionListAdapter.swap(allTransactions)
    }
}