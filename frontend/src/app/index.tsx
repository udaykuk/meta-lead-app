import * as Device from 'expo-device';
import { Platform, StyleSheet } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';

import { AnimatedIcon } from '@/components/animated-icon';
import { LeadCard } from '@/components/lead-card';
import { ThemedText } from '@/components/themed-text';
import { ThemedView } from '@/components/themed-view';
import { WebBadge } from '@/components/web-badge';
import { BottomTabInset, MaxContentWidth, Spacing } from '@/constants/theme';

function getDevMenuHint() {
  if (Platform.OS === 'web') {
    return <ThemedText type="small">use browser devtools</ThemedText>;
  }
  if (Device.isDevice) {
    return (
      <ThemedText type="small">
        shake device or press <ThemedText type="code">m</ThemedText> in terminal
      </ThemedText>
    );
  }
  const shortcut = Platform.OS === 'android' ? 'cmd+m (or ctrl+m)' : 'cmd+d';
  return (
    <ThemedText type="small">
      press <ThemedText type="code">{shortcut}</ThemedText>
    </ThemedText>
  );
}

export default function HomeScreen() {
  return (
    <ThemedView style={styles.container}>
      <SafeAreaView style={styles.safeArea}>
        <ThemedView style={styles.heroSection}>
          <AnimatedIcon />
          <ThemedText type="title" style={styles.title}>
            Meta Leads Dashboard
          </ThemedText>
        </ThemedView>

        <ThemedText type="code" style={styles.code}>
          Recent Leads
        </ThemedText>

        <ThemedView type="backgroundElement" style={styles.stepContainer}>
          <LeadCard
            name="react lead 1"
            email={"src/app/index.tsx" }
            phone={"123-456-7890"}
          />
          <LeadCard
            name="actual lead 2"
            email={"getDevMenuHint()"}
            phone={"098-765-4321"}
          />
          <LeadCard
            name="recent lead 2 and so on"
            email={"npm run reset-project"}
            phone={"123-456-7890"}
          />
        </ThemedView>

        {Platform.OS === 'web' && <WebBadge />}
      </SafeAreaView>
    </ThemedView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    flexDirection: 'row',
    backgroundColor: '#021826',
  },
  safeArea: {
    flex: 1,
    paddingHorizontal: Spacing.four,
    alignItems: 'center',
    gap: Spacing.three,
    paddingBottom: BottomTabInset + Spacing.three,
    maxWidth: MaxContentWidth,
  },
  heroSection: {
    alignItems: 'center',
    justifyContent: 'center',
    flex: 1,
    paddingHorizontal: Spacing.four,
    gap: Spacing.four,
    backgroundColor: '#021826',
  },
  title: {
    textAlign: 'center',
    color: '#E4EFF0',
  },
  code: {
    textTransform: 'uppercase',
    color: '#0F8C8C',
  },
  stepContainer: {
    gap: Spacing.three,
    alignSelf: 'stretch',
    paddingHorizontal: Spacing.two,
    paddingVertical: Spacing.four,
    borderRadius: Spacing.two,
    backgroundColor: '#012840',
  },
});
