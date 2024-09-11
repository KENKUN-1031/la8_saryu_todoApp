package app.yoshida.saryu.todoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import app.yoshida.saryu.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerViewAdapter

    private val list: List<TodoData> = listOf(
        TodoData(0L, "みかん"),
        TodoData(1L, "りんご"),
        TodoData(2L, "いちご"),
        TodoData(3L, "れもん"),
        TodoData(4L, "めろん"),
        TodoData(5L, "ばなな"),
        TodoData(6L, "すいか"),
        TodoData(7L, "ぶどう"),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        adapter = RecyclerViewAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        adapter.submitList(list.toMutableList())
    }
}