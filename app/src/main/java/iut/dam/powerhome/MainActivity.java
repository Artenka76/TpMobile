package iut.dam.powerhome;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import iut.dam.powerhome.fragments.HabitatFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerDL;
    private FragmentManager fm;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Récupérer les vues
        drawerDL = findViewById(R.id.dl_drawer);
        NavigationView navNV = findViewById(R.id.nv_navigation);
        fm = getSupportFragmentManager();

        // 2. Créer le toggle (bouton hamburger ☰)
        toggle = new ActionBarDrawerToggle(
                this, drawerDL,
                R.string.open_menu,
                R.string.close_menu
        );
        drawerDL.addDrawerListener(toggle);
        toggle.syncState(); // synchronise l'état de l'icône avec l'état du drawer

        // 3. Activer le bouton home (←) dans l'ActionBar pour ouvrir le drawer
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        // 4. Écouter les clics dans le menu
        navNV.setNavigationItemSelectedListener(this);

        // 5. Afficher le premier fragment par défaut au démarrage
        navNV.getMenu().performIdentifierAction(R.id.nav_habitat, 0);
    }

    // Nécessaire pour que le toggle intercepte le clic sur le bouton ☰
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Appelé quand l'utilisateur clique sur un item du menu latéral
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;

        if (item.getItemId() == R.id.nav_habitat) {
            fragment = new HabitatFragment();
        }

        if (fragment != null) {
            // Remplacer le contenu du FrameLayout par le fragment choisi
            fm.beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }

        // Fermer le menu après la sélection
        drawerDL.closeDrawer(GravityCompat.START);
        return true;
    }
}