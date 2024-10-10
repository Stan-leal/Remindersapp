package com.example.remindersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remindersapp.data.DataSource
import com.example.remindersapp.model.Reminder
import com.example.remindersapp.ui.theme.RemindersappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RemindersappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ReminderApp()
                }
            }
        }
    }
}

@Composable
fun ReminderApp() {
    RemindersList(reminders = DataSource.reminders)
}
@Composable
fun RemindersList(reminders: List<Reminder>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(reminders) { reminder ->
            ReminderCard(reminder = reminder, modifier = Modifier.padding(8.dp))
        }
    }
}
@Composable
fun ReminderCard(reminder: Reminder, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = stringResource(id = reminder.day),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
            )
            Image(
                painter = painterResource(id = reminder.imageRes),
                contentDescription = stringResource(id = reminder.text),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
                    .background(Color.Black),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = reminder.text),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
fun ReminderCardPreview() {
    RemindersappTheme {
        ReminderCard(reminder = DataSource.reminders[0])
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewRemindersApp() {
    RemindersappTheme {
        ReminderApp()
    }
}